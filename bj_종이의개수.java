package day0329;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_종이의개수 {
	static int N, map[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0329/paper"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		int result[] = new int[3];
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(0, 0, N));
		while (!que.isEmpty()) {
			Point p = que.poll();
//			System.out.println(p.y+" "+p.x);
			int check = map[p.y][p.x];
			boolean flag = false;
			for (int i = p.y; i < p.y + p.cnt; i++) {
				for (int j = p.x; j < p.x + p.cnt; j++) {
					if (map[i][j] != check) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			if (flag) { // 쪼개기
				if (p.cnt / 3 != 1) {
					int n = p.cnt / 3;
					for (int i =0; i < 3; i++) {
						for (int j =0; j <3; j++) {
//							System.out.println("add : "+(p.y + (i * n))+" "+(p.x + (j * n)));
							que.add(new Point(p.y + (i * n), p.x + (j * n), n));
						}
					}
				}else { //3*3
					for (int i = p.y; i < p.y + p.cnt; i++) {
						for (int j = p.x; j < p.x + p.cnt; j++) {
							result[map[i][j]+1]++;
						}
					}
				}

			} else { // 다 똑같음.
				result[check+1]++;
			}

		}
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
//		System.out.println(Arrays.toString(result));
	}

	static class Point {
		int y;
		int x;
		int cnt;

		public Point(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

	}
}
