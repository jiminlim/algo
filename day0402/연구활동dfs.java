package com.corona.day0402;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구활동dfs {
	static int N,M,min;
	static int[][] bb;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("연구활동")));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		
		bb = new int[N+1][N+1];
		visited = new int[N+1];
		min = Integer.MAX_VALUE	;
		bfs(1,0);
		
		
	}
	private static void bfs(int i, int value) {
		
		if (i==N) {
			if (min>value) {
				min = value;
			}
			return;
		}
		for (int j = 1; j < bb.length; j++) {
			
		}
	}

}
