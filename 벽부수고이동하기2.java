package Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기2_BFS {
    public static int map[][], min,N,M,K;
    public static boolean arrive;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/File/벽부숴"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N= Integer.parseInt(tk.nextToken());
        M= Integer.parseInt(tk.nextToken());
        K= Integer.parseInt(tk.nextToken());
        min = Integer.MAX_VALUE;
        map = new int[N+1][M+1];

        arrive = false;
        for(int i = 1; i<=N; i++){
            String str = br.readLine();
            for(int j = 1; j<=M; j++){
                char n = str.charAt(j-1);
                map[i][j] = n-'0';
            }
        }
        boolean[][][] visit = new boolean[N+1][M+1][K+1];

       // DFS(1,1, 1, K, visit);

       Queue<Go> que = new LinkedList<>();
       que.offer(new Go(1,1,0,1));
       visit[1][1][0] = true;
       while(!que.isEmpty()){
           Go go = que.poll();

            if(go.y == N && go.x == M) {
                arrive=true;
                min = Math.min(min, go.min);
            }
           for(int d = 0; d<4; d++){
               int ny = go.y + dir[d][0];
               int nx = go.x + dir[d][1];
               if(ny < 1|| nx<1|| ny> N|| nx> M) continue;
               if(map[ny][nx] == 1){//벽일때
                   if(go.k < K && !visit[ny][nx][go.k+1]){ // 벽 깎을 수 있고
                       visit[ny][nx][go.k+1] = true;
                       que.add(new Go(ny,nx,go.k+1,go.min+1));
                   }
               }else {
                   if(!visit[ny][nx][go.k]){ //방문 안했니?
                       visit[ny][nx][go.k] = true;
                       que.add(new Go(ny,nx,go.k,go.min+1));
                   }

               }
           }

       }

        if(!arrive){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
    static class Go{
        int y; int x; int k ;int min;
        public Go(int y, int x, int k , int min){
            this.y = y; this.x = x; this.k = k; this.min = min;
        }
    }
    public static int[][] dir = {
            {-1,0},{1,0},{0,-1},{0,1}
    };

}
