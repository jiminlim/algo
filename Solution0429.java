import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution0429 {
    public static int map[][];
    public static int N,M,startNumber;
    public static boolean[] visit;
    public static String bfsResult,dfsResult;
    public static void main(String[] args) throws Exception{
       System.setIn(new FileInputStream("C:/Project/algorithm/0429/file"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        startNumber = Integer.parseInt(tk.nextToken())-1;
        

        map = new int[N][N];
        visit = new boolean[N];
        for(int i =0 ;i<M ;i++ ){
            tk = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(tk.nextToken())-1;
            int point2 = Integer.parseInt(tk.nextToken())-1;

            map[point1][point2] = 1;
            map[point2][point1] = 1;
        }

        dfsResult = (startNumber+1)+""; 
        bfsResult = dfsResult;
        startDfs(startNumber);
        Arrays.fill(visit, false);
        startBfs(startNumber);
        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }
    private static void startBfs(int point) {
        visit[point]=true;
        Queue<Integer> que = new LinkedList<>();
        que.add(point);

        while(!que.isEmpty()){
            int peek = que.poll();
            for(int i =0; i<N;i++  ){
                if(peek==i) continue;
                if(!visit[i] && map[peek][i] == 1){
                    bfsResult+=" "+(i+1);
                    visit[i]=true;
                    que.add(i);
                }
            }
        }


    }
    private static void startDfs(int point) {
        visit[point]=true;
        for(int i=0; i<N;i++ ){
            if(point == i) continue;
            if(map[point][i]==1){
                if(!visit[i]){
                    dfsResult+= " "+(i+1);
                    startDfs(i);
                }
            }
        }

    }
}