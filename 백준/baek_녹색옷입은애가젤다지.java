package baekjoon;

import java.io.*;
import java.util.*;

public class baek_녹색옷입은애가젤다지 {
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    
    static class Jelda{
        int y; int x; int w;
        public Jelda (int y, int x, int w  ){
            this.y = y; this.x = x; this.w = w;
        }
    }
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/File/젤다"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = 1;
		while(true) {
			
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] map = new int[N][N];
	        int[][] costmap = new int[N][N]; // 비용저장.
		        for(int i=0; i<N; i++) {
		            Arrays.fill(costmap[i], Integer.MAX_VALUE);
		            StringTokenizer tk = new StringTokenizer(br.readLine());
		            for(int j=0; j<N; j++ ){
		                map[i][j] = Integer.parseInt(tk.nextToken());
		            }
		        }
		        
		        //젤다를 찾으러 가자
		        Queue<Jelda> que = new LinkedList<Jelda>();
		        que.add(new Jelda(0,0,map[0][0]));
		        costmap[0][0] = map[0][0];
		        
		        while(!que.isEmpty()){
		            Jelda jd = que.poll();
		            
		            for(int d =0 ;d<4; d++){
		                int ny = jd.y +dir[d][0];
		                int nx = jd.x + dir[d][1];
		                if(ny<0 || nx<0 || ny>= N|| nx>= N) continue;
		                int moveCost = jd.w + map[ny][nx];
		                if(costmap[ny][nx] > moveCost){ // 작니?
		                	//System.out.println(ny+" "+nx);
		                	costmap[ny][nx] = moveCost;
		                    que.add(new Jelda(ny,nx, moveCost));
		                }
		            }
		        }
		        
		        System.out.println("Problem "+number+":"+costmap[N-1][N-1]);
		        number++;
		}
		 
		
	}

}
