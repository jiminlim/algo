package com.corona.day0503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1949_등산로 {
	static int N, K, max;
	static int[][] map;
	static List<int[]> xylist;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] v;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0503/등산로"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());
			map = new int[N][N];
			v = new boolean[N][N];
			xylist = new ArrayList<int[]>();
			int high = 0;
			max =0;
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(tk.nextToken());
					map[i][j] = input;
					high = Math.max(map[i][j], high);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==high) {
//						v[i][j] = true;
						dfs(i, j, 1);
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}

	}

	private static void dfs(int y, int x, int cnt) {
//		System.out.println(y+" "+x+" :: "+map[y][x]);
		max = Math.max(max, cnt);
		v[y][x] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
//			System.out.println("_________"+ny+" "+nx+" ㅅㅎㅈㅇ"+d+"//// 현재위치 "+y+" "+x);
			if (check(ny, nx) && !v[ny][nx]) {
				if (map[ny][nx] < map[y][x]) {
//					System.out.println(ny+" "+nx+" / "+map[ny][nx]);
					dfs(ny, nx, ++cnt);
					cnt--;
				} else {
					if (!flag) {
//						System.out.println("else   "+ny+" "+nx+" "+map[ny][nx]);
						int tmp = map[ny][nx];
						int tmpK = calK(map[ny][nx], map[y][x]);
//						System.out.println("깍아 "+tmpK);
						if (tmpK == tmp) {
							v[y][x] = false;
//							System.out.println("return");
//							return;
							continue;
						}
						flag = true;
						map[ny][nx] = tmpK;
//						print();
						dfs(ny, nx, ++cnt);
						map[ny][nx] = tmp;
						flag = false;
						cnt--;
					}
				}
			}
		}
		v[y][x] = false;
	}

	private static void print() {
		System.out.println("_______________________");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int calK(int next, int value) {
		int max = -1;
		for (int i = 1; i <= K; i++) {
			if (next - i >= value)
				continue;
			if (next - i < 0)
				break;
			if (next - i >= max)
				max = next - i;
		}
		if (max == -1)
			max = next;
		return max;
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < N)
			return true;
		return false;
	}
}

/*
#1 6
#2 3
#3 7
#4 4
#5 2
#6 12
#7 6
#8 7
#9 10
#10 19
*/