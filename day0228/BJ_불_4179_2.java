package com.corona.day0228;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_불_4179_2 {
	static int R, C;
	static char[][] fire;
	static int[][] fv, jv;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int lasty, lastx;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("불"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		fire = new char[R][C];
		fv = new int[R][C];
		jv = new int[R][C];
		ArrayList<int[]> fa = new ArrayList<>();
		int jx = 0, jy = 0, fc = 0;
		for (int i = 0; i < R; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < C; j++) {
				char num = sb.charAt(j);
				fire[i][j] = num;
				if (num == 'F') {
					fa.add(new int[] { i, j });
				}
				if (num == 'J') {
					jx = j;
					jy = i;
				}
			}
		}
		Queue<int[]> fque = new LinkedList<>();
		Queue<int[]> jque = new LinkedList<>();
		int[] xx;
		int fcnt=0,jcnt=1;
		if (!fa.isEmpty()) {
			for (int z = 0; z < fa.size(); z++) {
				fcnt++;
				xx = fa.get(z);
				fque.offer(new int[] { xx[0], xx[1] });
				fv[xx[0]][xx[1]] = 0;
			}
			
		}
		jque.offer(new int[] { jy, jx });
		jv[jy][jx] = 0;

		boolean flag = false;
		while (!jque.isEmpty() && !flag) {
//			print(fire);

			
			if (!fa.isEmpty()) {// 지훈만
				int fcc =0;
				for (int i = 0; i < fcnt; i++) {
					int[] ff = fque.poll();
					for (int d = 0; d < 4; d++) {
						int ffy = ff[0] + dy[d];
						int ffx = ff[1] + dx[d];
						if (safe(ffy, ffx) && fv[ffy][ffx] == 0 && (fire[ffy][ffx] == '.' || fire[ffy][ffx] == 'J')) {
							fv[ffy][ffx] = fv[ff[0]][ff[1]] + 1;
							fire[ffy][ffx] = 'F';
							fque.offer(new int[] { ffy, ffx });
							fcc++;
						}
					}
				}
				fcnt=fcc;
			}
			int jcc =0;
			for (int i = 0; i < jcnt; i++) {
				int[] jj = jque.poll();
				for (int d = 0; d < 4; d++) {
					int jjy = jj[0] + dy[d];
					int jjx = jj[1] + dx[d];
					if (!safe(jjy, jjx)) {
						lasty = jj[0];
						lastx = jj[1];
						flag = true;
						break;
					}
					if (safe(jjy, jjx) && jv[jjy][jjx] == 0 && fire[jjy][jjx] == '.') {
						jv[jjy][jjx] = jv[jj[0]][jj[1]] + 1;
						fire[jjy][jjx] = 'J';
						jque.offer(new int[] { jjy, jjx });
						jcc++;
					}
				}
			}
			jcnt=jcc;
		

		}
		if (flag) {
			System.out.println(jv[lasty][lastx] + 1);
		} else {
			System.out.println("IMPOSSIBLE");
		}
//      for (int i = 0; i < R; i++) {
//         for (int j = 0; j < C; j++) {
//            System.out.print(fire[i][j] + " ");
//         }
//         System.out.println();
//      }

//      System.out.println();
//      for (int i = 0; i < R; i++) {
//         for (int j = 0; j < C; j++) {
//            System.out.print(jv[i][j] + " ");
//         }
//         System.out.println();
//      }
//      System.out.println();
//      for (int i = 0; i < R; i++) {
//         for (int j = 0; j < C; j++) {
//            System.out.print(fv[i][j] + " ");
//         }
//         System.out.println();
//      }
//      System.out.println();

	}

	private static void print(char[][] fire2) {
		for (int i = 0; i < fire2.length; i++) {
			for (int j = 0; j < fire2[i].length; j++) {
				System.out.print(fire2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && y < R && x < C) {
			return true;
		}
		return false;
	}

}