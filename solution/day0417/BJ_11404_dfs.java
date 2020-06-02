package com.corona.day0417;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_dfs {
	static int N, M;
	static int[][] map, result;
	static int c;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0417/11404"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		M =Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N][N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		StringTokenizer tk;
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tk.nextToken()) - 1;
			int b = Integer.parseInt(tk.nextToken()) - 1;
			int c = Integer.parseInt(tk.nextToken());
			if (c < map[a][b])
				map[a][b] = c;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					c = i;
					dfs(i, j, 0);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

	private static void dfs(int i, int j, int cnt) {
		if (i == j) { // 도착했다면
			if (result[c][j] == 0) {
				result[c][j] = cnt;
			} else {
				if (result[c][j] > cnt)
					result[c][j] = cnt;
			}
			return;
		}
		for (int n = 0; n < N; n++) {
			if (n == i)
				continue;
			if (!v[i] && map[i][n] != Integer.MAX_VALUE) {
				v[i] = true;
				cnt += map[i][n];
				dfs(n, j, cnt);
				v[i] = false;
				cnt -= map[i][n];
			}
		}
	}

}
