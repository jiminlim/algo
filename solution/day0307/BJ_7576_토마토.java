package com.corona.day0307;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {
	static int M, N;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("토마토"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());

		M = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		map = new int[N][M];
		Queue<int[]> que = new LinkedList<int[]>();
		int tomato_count = 0;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] == 1) {
					que.add(new int[] { i, j });
					tomato_count++;
				}
			}
		}
		if (tomato_count != N * M) {
			int result = bfs(que, 1, tomato_count);
			tomato_count = check_tomato(result);
		} else {
			tomato_count = 0; // 토마토가 처음부터 익어있었다.
		}

		System.out.println(tomato_count);

	}

	private static int bfs(Queue<int[]> que, int cnt, int tomato_count) {
		int cc = tomato_count;
		while (!que.isEmpty()) {
			int count = 0;
			for (int c = 0; c < cc; c++) {
				int[] yx = que.poll();
				for (int i = 0; i < 4; i++) {
					int y = yx[0] + dy[i];
					int x = yx[1] + dx[i];
					if (check_yx(y, x) && map[y][x] == 0) {
						map[y][x] = cnt;
						que.add(new int[] { y, x });
						count++;

					}
				}
			}
			if (count == 0) {
				return cnt - 1;
			}
			cc = count;
			cnt++;
//			print();
		}
		return cnt - 1;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean check_yx(int y, int x) {
		if (y >= 0 && x >= 0 && y < N && x < M) {
			return true;
		}
		return false;
	}

	private static int check_tomato(int result) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return -1; // 모두 익지 못했다.
				}
			}
		}
		return result;// 모두 익었다.
	}
}
