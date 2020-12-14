package day1214;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_충전_5644 {
	static int M, A;
	static int[][] move, dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static LinkedList<Point> map[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1214/충전"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testcase; tc++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tk.nextToken());
			A = Integer.parseInt(tk.nextToken());
			move = new int[2][M + 1];
			map = new LinkedList[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = new LinkedList<Point>();
				}
			}
			tk = new StringTokenizer(br.readLine());
			StringTokenizer tk2 = new StringTokenizer(br.readLine());
			move[0][0] = 0;
			move[1][0] = 0;
			for (int i = 1; i <= M; i++) {
				move[0][i] = Integer.parseInt(tk.nextToken());
				move[1][i] = Integer.parseInt(tk2.nextToken());
			}

			ArrayList<int[]> AP = new ArrayList<int[]>();
			for (int i = 0; i < A; i++) {
				tk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(tk.nextToken()) - 1;
				int y = Integer.parseInt(tk.nextToken()) - 1;
				int dp = Integer.parseInt(tk.nextToken());
				int power = Integer.parseInt(tk.nextToken());
				AP.add(new int[] { y, x, dp, power });
				map[y][x].add(new Point(i, power));
				// x,y,c,p
			}
			// map -bfs 설정
			for (int i = 0; i < A; i++) {
				bfs(AP.get(i), i);
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					Collections.sort(map[i][j]);
				}
			}
			// 사용자 궤적 이동
			int ay = 0;
			int ax = 0;
			int by = 9;
			int bx = 9;
			int result = 0;
			for (int m = 0; m <= M; m++) {
				// A이동
				ay = ay + dir[move[0][m]][0];
				ax = ax + dir[move[0][m]][1];

				// B이동
				by = by + dir[move[1][m]][0];
				bx = bx + dir[move[1][m]][1];
				if (map[ay][ax].size() == 0 || map[by][bx].size() == 0) {
					if (map[ay][ax].size() != 0)
						result += map[ay][ax].get(0).power;
					if (map[by][bx].size() != 0)
						result += map[by][bx].get(0).power;
				} else { // 둘다 무조건 1개 씩은 가지고 있음.
					// a는 첫번쨰
					
					int a = map[ay][ax].get(0).number;
					int b = map[by][bx].get(0).number;

					if (a == b) {
						int sum = map[ay][ax].get(0).power;
						// a 1 b 2
						if (map[by][bx].size() > 1)
							sum = Math.max(sum, map[ay][ax].get(0).power + map[by][bx].get(1).power);
						// b 1 a 2
						if (map[ay][ax].size() > 1)
							sum = Math.max(sum, map[ay][ax].get(1).power + map[by][bx].get(0).power);
						result += sum;
					} else {
						result += map[ay][ax].get(0).power + map[by][bx].get(0).power;
					}
					// b는 첫번째
				}
			}

			System.out.println("#" + (tc + 1) + " " + result);
		}
	}

	private static void bfs(int[] info, int number) {
		int y = info[0];
		int x = info[1];
		Queue<int[]> que = new LinkedList<int[]>();
		boolean[][] visit = new boolean[10][10];
		que.offer(new int[] { y, x });
		visit[y][x] = true;
		int c = info[2];
		int size = 0;
		while (!que.isEmpty()) {
			size = que.size();
			if (c-- == 0) {
				break;
			}
			for (int s = 0; s < size; s++) {
				int[] arr = que.poll();
				for (int i = 1; i < 5; i++) {
					int ny = arr[0] + dir[i][0];
					int nx = arr[1] + dir[i][1];

					if (check(ny, nx) && !visit[ny][nx]) {
						que.offer(new int[] { ny, nx });
						visit[ny][nx] = true;
						map[ny][nx].add(new Point(number, info[3]));
					}
				}

			}
		}

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < 10 && nx < 10)
			return true;
		return false;
	}

	static class Point implements Comparable<Point> { // 파워 큰거로 정렬 추가
		int number;
		int power;

		public Point(int number, int power) {
			super();
			this.number = number;
			this.power = power;
		}

		@Override
		public int compareTo(Point p) {
			if (this.power > p.power)
				return -1;
			else if (this.power < p.power)
				return 1;
			else
				return 0;
		}

	}

}
