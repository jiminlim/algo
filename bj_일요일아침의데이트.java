package day1216;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_일요일아침의데이트 {
	static int N, M;
	static char[][] map;
	static int sy, sx, ey, ex;
	static PriorityQueue<Point> pq;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1216/일요일"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				if (ch == 'S') {
					sy = i;
					sx = j;
				} else if (ch == 'F') {
					ey = i;
					ex = j;
				}
				map[i][j] = ch;
			}
		}

		// print();
		pq = new PriorityQueue<Point>();
		visit = new boolean[N][M];
		Point result = bfs();
		System.out.println(result.trash + " " + result.beside);

	}

	private static Point bfs() {
		pq.offer(new Point(sy, sx, 0, 0, 0));
		visit[sy][sx] = true;
		Point p = null;
		while (!pq.isEmpty()) {
			p = pq.poll();

//			System.out.println(p.y+" "+p.x+"  / "+p.deep+" "+p.trash+" "+p.beside);
//			if (p.y == ey && p.x == ex) {
//				return p;
//			}
			boolean finish= false;
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dir[i][0];
				int nx = p.x + dir[i][1];
				if (check(ny, nx) && !visit[ny][nx]) {
					if(ny==ey && nx == ex) {
						finish = true;
						continue;
					}
					if (map[ny][nx] == 'g') {
						visit[ny][nx] = true;
						pq.offer(new Point(ny, nx, p.deep + 1, p.trash+1, p.beside));
					}else {
						visit[ny][nx] = true;
						boolean bflag = false;
						for (int j = 0; j < 4; j++) {
							int ty = ny + dir[j][0];
							int tx = nx + dir[j][1];
							if (check(ty, tx) && map[ty][tx] == 'g') {
								bflag = true;
								break;
							}
						}
						if (bflag)
							pq.offer(new Point(ny, nx, p.deep + 1, p.trash, p.beside + 1));
						else
							pq.offer(new Point(ny, nx, p.deep + 1, p.trash, p.beside));
					}
				}
			}
			if(finish) {
				return p;
			}
		}
		return p;

	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M)
			return true;
		return false;
	}


	static class Point implements Comparable<Point> {
		int y;
		int x;
		int deep;
		int trash;
		int beside;

		public Point(int y, int x, int deep, int trash, int beside) {
			super();
			this.y = y;
			this.x = x;
			this.deep = deep;
			this.trash = trash;
			this.beside = beside;
		}

		@Override
		public int compareTo(Point p) {

			if (this.trash < p.trash)
				return -1;
			else if (this.trash > p.trash)
				return 1;
			else {
				if (this.beside < p.beside)
					return -1;
				else if (this.beside > p.beside)
					return 1;
				else {
//					if (this.deep < p.deep) //깊이는 고려 안해도 괜츈
//						return -1;
//					else if (this.deep > p.deep)
//						return 1;
					return 0;
				}
			}
		}

	}

}
