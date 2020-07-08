package com.corona.day0228;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로 {

	static int H, W;
	static char[][] map;
	static int[][] visited;
	static int[] count;
	static int sy, sx, ey, ex;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H][W];
		visited = new int[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = sc.next().toCharArray();
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'S') {
					sy = i;
					sx = j;
				} else if (map[i][j] == 'G') {
					ey = i;
					ex = j;
				}
			}
		}

		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { sy, sx });
		visited[sy][sx] = 0;

		while (!que.isEmpty()) {
			int[] cu = que.poll();
			if (ey == cu[0] && ex == cu[1]) {
				break;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cu[0] + dy[d];
				int nx = cu[1] + dx[d];
				if (check(ny, nx) && (map[ny][nx] == '.' || map[ny][nx] == 'G') && visited[ny][nx] == 0) {
					visited[ny][nx] = visited[cu[0]][cu[1]] + 1;
					que.offer(new int[] { ny, nx });
				}
			}
		}
//			swap(ny,nx);

		print(visited);

	}

	private static void swap(int... a) {
		int tmp = a[0];
		a[0] = a[1];
		a[1] = tmp;
	}

	private static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void print(char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
			return true;
		} else
			return false;
	}

}


/*
5 5
#S###
#...#
#.#.#
#....
###G#

 */