package com.corona.day0326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_유기농배추 {
	static int T, M, N, K;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("유기농배추"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tk.nextToken()); // 가로길이
			N = Integer.parseInt(tk.nextToken()); // 세로길이
			K = Integer.parseInt(tk.nextToken()); // 배추 수
			map = new int[N][M];
			v = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				tk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tk.nextToken());
				int y = Integer.parseInt(tk.nextToken());
				map[y][x] = 1;
			}
			int cnt =2;
			// 1. dfs
			// map에 지렁이인거 2부터 집어 넣는다 .
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]==1) {
						dfs(i, j, cnt);
						cnt++;
					}
				}
			}
//			print();
			System.out.println(cnt-2);
		}
	}

	private static void dfs(int y, int x, int cnt) {// cnt 2부터 시작
		map[y][x] = cnt;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (check(ny, nx) && map[ny][nx] == 1) {
				dfs(ny, nx, cnt);
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
			return true;
		}
		return false;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
