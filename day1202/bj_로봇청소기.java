package day1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_로봇청소기 {
	static int N, M, y, x, d;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1202/로봇"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(br.readLine());
		y = Integer.parseInt(tk.nextToken());
		x = Integer.parseInt(tk.nextToken());
		d = Integer.parseInt(tk.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int result = 0;
		boolean flag = false;
		while (!flag) {
			// 현재 위치 청소
			if(map[y][x]==0)
				result++; // 청소하는 칸의 갯수
			map[y][x] = 2;
			// 조건 시작
			for (int k = 0; k < 4; k++) {
				// 왼쪽방향 탐색
				d--;
				if (d < 0)
					d = 3;
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];

				// 왼쪽 청소 !=2 다음 회전 전진 break;
				if (map[ny][nx] == 0) {
					y = ny;
					x = nx; // 전진
					break;
				}
				// 왼쪽 청소 ==2 다음 회전 continue;
//				else if (map[ny][nx] != 0) {
//					System.out.println("B");
//
//				}
				// 모두 청소, 벽 / 방향 유지 / 후진 / k=0; 2번으로 돌아감.
				if (k == 3) {
					int by = y - dir[d][0];
					int bx = x - dir[d][1];
					if (map[by][bx] != 1) { // 후진 ㅐ
						y = by;
						x = bx;
					} else {// 후진 x
						// 모두 청소 벽 후진 x / flag = true; break;
						flag = true;
						break;
					}
				}

			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
		System.out.println(result);

	}


}
