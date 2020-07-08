package com.corona.day0515;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int M, N, cnt;
	static int[][] map;
	static boolean[][] vi;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0515/치즈"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		map = new int[M + 1][N + 1];
		vi = new boolean[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		dfs2(0, 0);
		int last = 0;
		while (true) {
			int stop = 0;
			for (int i = 1; i < M + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
						stop++;
					}
				}
			}
			if (stop == 0) {
				break;
			}else {
				last = stop;
			}
			for (boolean[] v : vi) {
				Arrays.fill(v,false);
			}
			dfs2(0, 0);
			cnt++;
		}
		System.out.println(cnt+" \n"+last);

	}

	private static void dfs2(int i, int j) {
		vi[i][j] = true;
		for (int n = 0; n < 4; n++) {
			int ny = i + dy[n];
			int nx = j + dx[n];
			if (check(ny, nx)) {
				if (map[ny][nx] == 1) {
					map[ny][nx] = -1;
				}
				if (!vi[ny][nx] && map[ny][nx] == 0) {
					dfs2(ny, nx);
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < M + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny <= M && nx <= N) {
			return true;
		}
		return false;
	}

}
