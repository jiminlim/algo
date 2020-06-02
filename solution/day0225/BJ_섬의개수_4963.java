package com.corona.day0225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_섬의개수_4963 {
	static int W, H;
	static int[][] map;
	static int cnt;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("섬의개수"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		while (true) {
			tk = new StringTokenizer(br.readLine());
			W = Integer.parseInt(tk.nextToken());
			H = Integer.parseInt(tk.nextToken());
			if (W == 0 && H == 0) {
				break;
			}
			map = new int[H + 2][W + 2];

			for (int i = 1; i < H + 1; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 1; j < W + 1; j++) {
					map[i][j] = Integer.parseInt(tk.nextToken());
				}
			}

			cnt = 2;
			for (int i = 0; i < H + 2; i++) {
				for (int j = 0; j < W + 2; j++) {
					if (map[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt - 2);
		}

	}

	private static void dfs(int i, int j) {
		map[i][j] = cnt;
		for (int d = 0; d < 8; d++) {
			int y = i + dy[d];
			int x = j + dx[d];
			if (safy(y, x) && map[y][x] == 1) {
				dfs(y, x);
			}
		}
	}

	private static boolean safy(int y, int x) {
		if (y > 0 && x > 0 && y < H + 1 && x < W + 1) {
			return true;
		}
		return false;
	}

}
