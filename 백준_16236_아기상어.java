import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.Position;

public class 백준_16236_아기상어 {
    static int N,time;
    static  int[][] map;
    static Position shark ; 
    public static <T> void main(String[] args) throws Exception{
        //입력
        System.setIn(new FileInputStream("C:/Project/algorithm/0429/file"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        shark = new Position(0, 0, 2,0);

        //물고기 위치 저장, 상어 처음 위치 저장
        for(int i =0; i<N; i++){
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
                if(map[i][j] == 9){ // 아기상어 위치
                    shark.y = i; shark.x = j;
                }
            }
        }

        time = 0;
        bfs( );

        //출력
        System.out.println(time);
    }

    private static int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
    private static void bfs() {
        Queue<Position> que = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        que.offer(new Position(shark.y, shark.x, 0, 0));
        visit[shark.y][shark.x] = true;
        map[shark.y][shark.x] =0 ;


        // for(int i =0; i<N; i++){
        //     for(int j =0;j<N; j++){
        //         System.out.print(map[i][j]+" ");
        //     }System.out.println();
        // }  System.out.println();

        int count_time =0;
        boolean stop = false;
        while(!que.isEmpty()){
            int size = que.size();
            PriorityQueue<Position> pq = new PriorityQueue<>();
            for(int s =0; s<size; s++){
                Position nshark = que.poll();
                for(int d =0; d<4;d++){
                    int ny = nshark.y +dir[d][0];
                    int nx = nshark.x +dir[d][1];

                    if(ny<0 || nx < 0 || ny >= N || nx >= N) continue;
                    if(visit[ny][nx]) continue;
                    visit[ny][nx]=true;
                    if(map[ny][nx]!=0 && map[ny][nx] < shark.size) {
                        pq.offer(new Position(ny, nx, map[ny][nx]));
                    }else{
                        if(map[ny][nx] <= shark.size)
                            que.offer(new Position(ny, nx, nshark.size, nshark.eatcount));
                    }


                }
            }
            count_time++;
            if(!pq.isEmpty()){
                Position fish = pq.poll();
                shark.y =fish.y;
                shark.x = fish.x;
                shark.eat();
                stop =true;

                break;
                

            }

        }
       
        if(stop){
            time+= count_time;
            bfs();
        }
       
        
    }
    public static class Position implements Comparable<Position>{
        int y; int x; int size;int eatcount ;

        public Position(int y, int x, int size,int eatcount){
            this.y = y ; this.x = x; this.size = size;this.eatcount = eatcount;
        }
        public Position(int y, int x, int size){
            this.y = y ; this.x = x; this.size = size;
        }

        public void eat() {
           this.eatcount ++;
            if(this.eatcount == this.size){
                this.size ++;
                this.eatcount = 0;            
            }
        }

        @Override
        public int compareTo(Position o) {     

            if(this.y > o.y) return 1;
            else if(this.y == o.y){
                if(this.x > o.x) return 1;                
            }
            return -1;
        }

        
    }
}
