//package Baek;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
public class baek_최단거리 {
    public static class Node implements Comparable<Node>{
        int end; int weight;
        public Node(int end, int weight){this.end = end; this.weight = weight;}
        @Override
        public int compareTo(Node node){
            return this.weight - node.weight;
        }
    }
    public static ArrayList<Node>[] list;
    public static int[] dist;
    public static int V,E,K;
    public static void main(String[] args) throws Exception{
        //입력값
        System.setIn(new FileInputStream("./src/File/최단거리"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine()  );
        V = Integer.parseInt(tk.nextToken());
        E = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        K =  Integer.parseInt(tk.nextToken());

        list = new ArrayList[V+1];
        for(int i=1 ; i<= V; i++){
            list[i] = new ArrayList<>();
        }

        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        //노트입력시켜주자
        for(int i=0 ;i<E; i++){
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end =  Integer.parseInt(tk.nextToken());
            int weight =  Integer.parseInt(tk.nextToken());
            list[start].add(new Node(end,weight));
        }

        //다익스트라
        dijkstra(K);
        //프린트
        for(int i=1; i <= V;i++){
            if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] visit = new boolean[V + 1];

        dist[start] = 0;
        que.add(new Node(start,0));
        //System.out.println(start+" start");

        while(!que.isEmpty()){
            Node node = que.poll();
            int cur = node.end;
           // System.out.println(node.end+" que start");
            if(visit[cur]) continue;
            visit[cur] = true;
           // System.out.println(Arrays.toString(visit));

            for(Node next : list[cur]){
               // System.out.println(next.end+" que next");
                if(dist[next.end] >  dist[cur] + next.weight){ //다음가는게 최소값이니?
                    dist[next.end] = dist[cur] + next.weight;
                    que.add(new Node(next.end,dist[next.end]));
                }
            }

        }
    }
}
