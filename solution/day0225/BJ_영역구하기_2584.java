/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
 */


package com.corona.day0225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_영역구하기_2584 {

	static int M, N, K;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int cnt;
	static int num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("영역구하기")));
		StringTokenizer tk;
		tk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			tk = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(tk.nextToken());
			int y1 = Integer.parseInt(tk.nextToken());
			int x = Integer.parseInt(tk.nextToken());
			int y = Integer.parseInt(tk.nextToken());

			for (int t = y1; t < y; t++) {
				for (int j = x1; j < x; j++) {
					map[t][j] = 1;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		cnt = 2;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					num = 1;
					dfs(i, j);
					cnt++;
					list.add(num);
				}
			}
		}
		System.out.println(cnt - 2);
		Collections.sort(list);
		for (int i = 0; i < (cnt-2); i++) {
			System.out.print(list.get(i)+" ");
		}

	}

	private static void dfs(int i, int j) {
		map[i][j] = cnt;
		for (int d = 0; d < 4; d++) {
			if (safe(i + dy[d], j + dx[d]) && map[i + dy[d]][j + dx[d]] == 0) {
				num++;
				dfs(i + dy[d], j + dx[d]);
			}
		}
	}

	private static boolean safe(int i, int j) {
		if (i >= 0 && j >= 0 && i < M && j < N) {
			return true;
		}
		return false;
	}
}
