package day1125;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_¹ì {
	static int[][] map, dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1125/¹ì"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int apple = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int a = 0; a < apple; a++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			map[Integer.parseInt(tk.nextToken()) - 1][Integer.parseInt(tk.nextToken()) - 1] = 2;
		}
		int snake = Integer.parseInt(br.readLine());
		int d = 0, time = 0;
		int sy = 0, sx = 0, ey = 0, ex = 0;
		Queue<Pos> que = new LinkedList<>();
		map[0][0] = 1;

		HashMap<Integer, String> hm = new HashMap();
		for (int s = 0; s < snake; s++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			hm.put(Integer.parseInt(tk.nextToken()), tk.nextToken());
		}
		// ¹ì ÀÌµ¿
		while (true) {
			int ny = sy + dir[d][0], nx = sx + dir[d][1];
			if (check(ny, nx, N)) {
				if (map[ny][nx] == 1) {
					break;
				}
				if (map[ny][nx] == 2) {
					sy = ny;
					sx = nx;
					que.add(new Pos(sy, sx));
					map[ny][nx] = 1;
				} else {
					map[ny][nx] = 1;
					sy = ny;
					sx = nx;
					que.add(new Pos(sy, sx));
					Pos p = que.poll();
					map[ey][ex] = 0;
					ey = p.y;
					ex = p.x;
				}
				time++;
				if (hm.containsKey(time)) {
					d = (hm.get(time).equals("D")) ? (d + 1) % 4 : (d + 3) % 4;
				}
			} else {
				break;
			}

		}

//	if(direction.equals("D"))
//	{ // ¿ì·Î È¸Àü
//		d++;
//		if (d == 4) {
//			d = 0;
//		}
//	}else
//	{// ÁÂ·Î È¸Àü
//		d--;
//		if (d < 0) {
//			d = 4;
//		}
//	}
//	
		System.out.println(time + 1);

	}

	private static boolean check(int ny, int nx, int N) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < N)
			return true;
		return false;
	}

	private static void print(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
//	

}
