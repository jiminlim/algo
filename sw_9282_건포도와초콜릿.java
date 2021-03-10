package day0310;

import java.util.Arrays;
import java.util.Scanner;

public class sw_9282_건포도와초콜릿 {
	static int map[][], dp[][][][] ; 
	static int N,M;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			dp=new int[N+1][M+1][N+1][M+1];
			for(int[][][] d1:dp) {
				for (int[][] d2 : d1) {
					for(int[] d3: d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			
			int result = dfs(0,0,N,M);
			
			System.out.println("#"+ tc+" "+result);
		}
	}
	private static int dfs(int y, int x, int h, int w) {
		if(h==1 && w==1) return 0;
		
		if(dp[y][x][h][w]!=Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}
		
		//영역별 건포도 갯수 
		int sum =0;
		for (int i = y; i < y+h; i++) {
			for (int j = x; j < x+w; j++) {
				sum += map[i][j];
			}
		}

		//가로 부터 자름
		for (int i = 1; i < h; i++) {
			if(dp[y][x][i][w]==Integer.MAX_VALUE) // dfs메소드를 호출하지 않기 위해서 한번 조건을 걸어줌.
				dp[y][x][i][w] = dfs(y,x,i,w);
			if(dp[y+i][x][h-i][w]==Integer.MAX_VALUE)
				dp[y+i][x][h-i][w] = dfs(y+i,x,h-i,w);
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], dp[y][x][i][w]+dp[y+i][x][h-i][w]+sum);
		}

		//세로 자름
		for (int i = 1; i < w; i++) {
			if(dp[y][x][h][i]==Integer.MAX_VALUE)
				dp[y][x][h][i] = dfs(y,x,h,i);
			if(dp[y][x+i][h][w-i]==Integer.MAX_VALUE)
				dp[y][x+i][h][w-i] = dfs(y,x+i,h,w-i);
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], dp[y][x][h][i]+dp[y][x+i][h][w-i]+sum);
		}
		
		return dp[y][x][h][w];
	}

}
