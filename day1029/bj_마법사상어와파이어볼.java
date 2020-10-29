package day1029;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_마법사상어와파이어볼 {
	static int N, M, K;
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static LinkedList<Fireball> map[][];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/day1029/마법사상어"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(tk.nextToken()) - 1;
			int c = Integer.parseInt(tk.nextToken()) - 1;
			int m = Integer.parseInt(tk.nextToken());
			int s = Integer.parseInt(tk.nextToken());
			int d = Integer.parseInt(tk.nextToken());
			map[r][c].add(new Fireball(m, s, d));
		}

		for (int i = 0; i < K; i++) {
			move();
		}
		// 합계출력
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Fireball data : map[i][j]) {
					sum += data.m;
				}
			}
		}
		System.out.println(sum);
	}

	private static void move() {
		LinkedList<Fireball> next[][] = new LinkedList[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				next[i][j] = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() >= 1) {
					for (Fireball data : map[i][j]) {
						int distance = data.s % N;
						int ny = i + (distance * dir[data.d][0]);
						int nx = j + (distance * dir[data.d][1]);
						if (ny >= N)
							ny -= N;
						if (ny < 0)
							ny += N;
						if (nx >= N)
							nx -= N;
						if (nx < 0)
							nx += N;
						next[ny][nx].add(new Fireball(data.m, data.s, data.d));
					}
				}

			}
		}
		map = next;
		divide();
	}

	private static void divide() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() > 1) {
					int m = 0, s = 0, d = 0;
					 boolean even = true, odd = true;
					for (Fireball data : map[i][j]) {
						m += data.m;
						s += data.s;
						d += data.d;
						if(data.d % 2 == 0)
                            odd = false;
                        else
                            even = false;
					}
					m /= 5;
					s /= map[i][j].size();

					map[i][j].clear();

					if(m > 0) {
                        for(int a = 0; a < 4; a++) {
                            if(odd || even)
                                map[i][j].add(new Fireball(m,s, 0 + 2*a));
                            else
                                map[i][j].add(new Fireball(m,s, 1 + 2*a));
                        }
                    }

				}
			}
		}
	}

	static class Fireball {
		int m, s, d;

		public Fireball(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

}
