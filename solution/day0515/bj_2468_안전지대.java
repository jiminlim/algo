package com.corona.day0515;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2468_안전지대 {
	static int N,answer;
	static int[][] map;
	static boolean[][] vi;
	static int[] dy= {-1,1,0,0} ; 
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("안전지대"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vi = new boolean[N][N];
		StringTokenizer tk;
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] > max) {
					max = map[i][j];
					continue;
				}
				if (map[i][j] < min) {
					min = map[i][j];
				}
			}
		}
		int cnt;
		for (int k = min; k <= max; k++) {
			cnt =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!vi[i][j] && map[i][j] > k) {
						vi[i][j]=true;
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			
			for(boolean[] v : vi) {
				Arrays.fill(v, false);
			} //초기화
			
			if(answer< cnt) {
				answer = cnt;
			}
		}
		
		System.out.println(answer==0? 1:answer);

	}

	private static void dfs(int i, int j, int wet) {
		for (int n = 0; n < 4; n++) {
			int ny = i+dy[n]; int nx = j+dx[n];
			if(ny>=0 &&ny< N && nx>=0 && nx <N && !vi[ny][nx] && map[ny][nx]>wet) {
				vi[ny][nx] = true;
				dfs(ny,nx,wet);
			}
		}
	}

}
