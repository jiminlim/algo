package day0226;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_1907_모래성쌓기 {
	static int[][] map, adj,
			dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int R, C, time;
	static Queue<int[]> que = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0226/모래"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
//		tc =1;
		for (int t = 1; t <= tc; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			R = Integer.parseInt(tk.nextToken());
			C = Integer.parseInt(tk.nextToken());
			que.clear();
			map = new int[R][C];
			adj = new int[R][C];
			for (int i = 0; i < R; i++) {
				StringBuilder sb = new StringBuilder(br.readLine());
				for (int j = 0; j < C; j++) {
					char a = sb.charAt(j);
					if (a != '.') {
						int input = a - '0';
						map[i][j] = input;
						adj[i][j] = input;
					} else {
						que.add(new int[] { i, j });
					}
				}
			}

			time = 0;

			// 파도 치기 시작
			while (!que.isEmpty()) {
				int size = que.size();
				for (int i = 0; i < size; i++) {
					int[] arr = que.poll();
					int y = arr[0];
					int x = arr[1];
					for (int j = 0; j < 8; j++) {
						int ny = y + dir[j][0];
						int nx = x + dir[j][1];
						if (ny < 0 || ny >= R || nx < 0 || nx >= C)
							continue;
						if (adj[ny][nx] == 0)
							continue;
						adj[ny][nx] -= 1;
						
						if (adj[ny][nx] == 0) {
							que.add(new int[] { ny, nx });
						}
					}
				}
				
				time++;
			}

			System.out.println("#" + t + " " + (time-1));
		}
	}

}
