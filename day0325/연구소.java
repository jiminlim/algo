package com.corona.day0325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map, combi;
	static int M, N, max;
	static ArrayList<int[]> list, virus;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("연구소"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		virus = new ArrayList<>();
		combi = new int[3][2];
		int n = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 1. 0인 좌표 arraylist에 넣기.
				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				}
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}

		// 2. arraylist에 있는 좌표들 중 3개 뽑기
		pickCOMBI(list.size(), 0, 0); // n= list길이 r=3
		System.out.println(max);
	}

	private static void pickCOMBI(int len, int start, int cnt) {
		if (cnt == 3) {
			// combi에 들어있는 좌표를 map에 1로 넣어줌.
			changeToMap(1);
			// 3. 바이러스(=2) 퍼트리기
			spreadBFS();
			// 4. 0 몇개인지 세기. -> max비교
			countZero();
			// 좌표 다시 0으로 바꿈
			changeToMap(0);
			return;
		}

		for (int i = start; i < len; i++) {
			int[] loc = list.get(i);
			combi[cnt][0] = loc[0];
			combi[cnt][1] = loc[1];
			pickCOMBI(len, i + 1, cnt + 1);
		}
	}

	private static void countZero() {
		int cntZ = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == false && map[i][j] == 0) {
					cntZ++;
				}
			}
		}
		if (cntZ > max) {
			max = cntZ;
		}
	}

	private static void spreadBFS() {
		visited = new boolean[N][M];
		for (int v = 0; v < virus.size(); v++) {
			Queue<int[]> que = new LinkedList<int[]>();
			que.add(virus.get(v));
			int firstLoc[] = virus.get(v);
			visited[firstLoc[0]][firstLoc[1]] = true;

			while (!que.isEmpty()) {
				int[] loc = que.poll();
				for (int i = 0; i < 4; i++) {
					int y = loc[0] + dy[i];
					int x = loc[1] + dx[i];
					if (check(y, x) && !visited[y][x] && map[y][x] == 0) {
						que.add(new int[] { y, x });
						visited[y][x] = true;
					}
				}

			}
		}
	}

	private static boolean check(int my, int mx) {
		if (my >= 0 && mx >= 0 && my < N && mx < M) {
			return true;
		}
		return false;
	}

	private static void changeToMap(int k) {
		for (int i = 0; i < 3; i++) {
			map[combi[i][0]][combi[i][1]] = k;
		}
	}

//	public static void print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(visited[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}