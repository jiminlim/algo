package dya0310;

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
			int sum1 = dfs(y,x,i,w);
			int sum2 = dfs(y+i,x,h-i,w);
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum1+sum2+sum);
		}

		//세로 자름
		for (int i = 1; i < w; i++) {
			int sum1 = dfs(y,x,h,i);
			int sum2 = dfs(y,x+i,h,w-i);
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum1+sum2+sum);
		}
		
		return dp[y][x][h][w];
	}

}
