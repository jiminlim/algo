package day1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_�κ�û�ұ� {
	static int N, M, y, x, d;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1202/�κ�"));
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
			// ���� ��ġ û��
			if(map[y][x]==0)
				result++; // û���ϴ� ĭ�� ����
			map[y][x] = 2;
			// ���� ����
			for (int k = 0; k < 4; k++) {
				// ���ʹ��� Ž��
				d--;
				if (d < 0)
					d = 3;
				int ny = y + dir[d][0];
				int nx = x + dir[d][1];

				// ���� û�� !=2 ���� ȸ�� ���� break;
				if (map[ny][nx] == 0) {
					y = ny;
					x = nx; // ����
					break;
				}
				// ���� û�� ==2 ���� ȸ�� continue;
//				else if (map[ny][nx] != 0) {
//					System.out.println("B");
//
//				}
				// ��� û��, �� / ���� ���� / ���� / k=0; 2������ ���ư�.
				if (k == 3) {
					int by = y - dir[d][0];
					int bx = x - dir[d][1];
					if (map[by][bx] != 1) { // ���� ��
						y = by;
						x = bx;
					} else {// ���� x
						// ��� û�� �� ���� x / flag = true; break;
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
