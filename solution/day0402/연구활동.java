package com.corona.day0402;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연구활동 {

	static int N, M;
	static int[][] bb;
	static int[] mm;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("연구활동"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		bb = new int[N + 1][N + 1];
		mm = new int[N + 1];
		Arrays.fill(mm, Integer.MAX_VALUE);
		mm[1] = 0;
		for (int t = 0; t < M; t++) {
			tk = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(tk.nextToken());
			int j = Integer.parseInt(tk.nextToken());
			bb[i][j] = Integer.parseInt(tk.nextToken());
		}
		// 입력 완료
		bfs(1);
		if (mm[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else
			System.out.println(mm[N]);
	}

	private static void bfs(int i) {
		if (i == N) {
			return;
		}
		for (int j = 1; j < bb.length; j++) {
			if (bb[i][j] != 0) {
				if (mm[j] > mm[i] + bb[i][j]) {
					mm[j] = mm[i] + bb[i][j];
				}
			}
		}
		bfs(i + 1);
	}

}
