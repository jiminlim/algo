package day0318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_마법사상어와파이어볼 {
	static int N, M, K;
	static ArrayList<Fire> map[][];
	static int[][] d1 = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } },
			d2 = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0318/마법사상어"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());

		map = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new ArrayList<Fire>();
			}
		}

		Queue<Fire> que = new LinkedList<Fire>();

		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(tk.nextToken());
			int x = Integer.parseInt(tk.nextToken());
			int m = Integer.parseInt(tk.nextToken());
			int s = Integer.parseInt(tk.nextToken());
			int d = Integer.parseInt(tk.nextToken());
			que.offer(new Fire(y, x, m, s, d));
		}

		// move start!
		while (K-- > 0) {
//			System.out.println(K);
			while (!que.isEmpty()) { // 이동시켜준다.
				Fire f = que.poll();
				int y = f.y;
				int x = f.x;
				for (int ss = 0; ss < f.s; ss++) {
					if (f.d % 2 == 0) { // d1
						y += d1[f.d / 2][0];
						x += d1[f.d / 2][1];
						if (y < 1 || y > N || x < 1 || x > N) {
							Fire nf = findyx(y, x);
							y = nf.y;
							x = nf.x;
						}

					} else { // d2
						y += d2[f.d / 2][0];
						x += d2[f.d / 2][1];
						if (y < 1 || y > N || x < 1 || x > N) {
							Fire nf = findyx(y, x);
							y = nf.y;
							x = nf.x;
						}
					}
				}
//				System.out.println(f.y + " " + f.x + " " + f.m + " " + f.s + " " + f.d);
//				System.out.println("next : " + y + " " + x);
				map[y][x].add(new Fire(y, x, f.m, f.s, f.d));
			}

//			System.out.println("----------");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j].size()+" ");
//				}System.out.println();
//			}
//			System.out.println("----------");
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int size = map[i][j].size();
					if (size == 0)
						continue;
					if (size == 1) {
//						System.out.println(i + " " + j + "off");
						que.offer(map[i][j].get(0));
						map[i][j] = new ArrayList<Fire>();
						continue;
					}
					// 2개 이상 합쳐진다.
					int mi = 0, si = 0, di = 0;
					boolean n1 = false, n2 = false;
					for (Fire f : map[i][j]) {
						mi += f.m;
						si += f.s;
						if (f.d % 2 == 0) { // 짝수
							n1 = true;
						} else {// 홀수
							n2 = true;
						}
					}
					mi = mi / 5;
					si = si / map[i][j].size();
					map[i][j] = new ArrayList<Fire>();
//					System.out.println(i + " " + j + "중간" + que.size() + " " + mi);
					if (mi > 0) { // 질량이 0이상일 경우만 퍼짐
						// 방향 구하기
						if ((n1 && n2) || (!n1 && !n2)) {
							for (int d = 0; d < 4; d++) {
//								int ny = i + d2[d][0];
//								int nx = j + d2[d][1];
//								Fire nf = findyx(ny,nx);
								que.offer(new Fire(i, j, mi, si, d * 2 + 1));
							}
						} else { // 모두 짝, 모두 홀
							for (int d = 0; d < 4; d++) {
//								int ny = i + d1[d][0];
//								int nx = j + d1[d][1];
//								Fire nf = findyx(ny,nx);
								que.offer(new Fire(i, j, mi, si, d * 2));
							}
						}
					}

				}
			}

		}
		int result = 0;
		while (!que.isEmpty()) {
			Fire f = que.poll();
			result += f.m;
		}
		System.out.println(result);

	}

	private static Fire findyx(int ny, int nx) {
		// 위아래 양옆 이어지도록
		if (ny < 1)
			ny = N;
		if (ny > N)
			ny = 1;
		if (nx < 1)
			nx = N;
		if (nx > N)
			nx = 1;

		return new Fire(ny, nx, 0, 0, 0);
	}

	static class Fire {
		int y;
		int x;
		int m; // 질량
		int s; // 속력
		int d; // 방향

		public Fire(int y, int x, int m, int s, int d) {
			super();
			this.y = y;
			this.x = x;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
}
