package com.corona.day0226;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class xBJ_불_4179 {
	static int R, C, cnt;
	static char[][] map, fmap;
	static int jx, jy;
	static int[] dy = { 1, 0, 0, -1 };
	static int[] dx = { 0, -1, 1, 0 };
	static int dead;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("불"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb;
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		map = new char[R][C];
		fmap = new char[R][C];
		boolean flag = true;
		int nofire = 0;
		for (int i = 0; i < map.length; i++) {
			sb = new StringBuilder();
			sb.append(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sb.charAt(j);
				if (map[i][j] == 'J') {
					jy = i;
					jx = j;
				}
				if (map[i][j] == 'F') {
					nofire++;
				}
			}
		}
		// 입력 완료
		cnt = 0;
		while (flag) {
			if (!check(jy, jx)) { // 가장자리를 나간다면
				flag = false;
			}
			System.out.println(nofire+" "+dead);
			if (nofire != 0) {
				fire();
			}
			flag = jihun();
			cnt++;
		}

		if (dead == -1) {
			System.out.println("impossible");
		} else {
			System.out.println(cnt);

		}

	}

	private static void fire() {
		for (int i = 0; i < R; i++) { // f찾아서 fmap에 넣어줌.
			for (int j = 0; j < C; j++) {
				if (fmap[i][j] == 'F') {
					continue;
				}
				if (map[i][j] == 'F') {
					fmap[i][j] = 'F';
				}
			}
		}

//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(fmap[i]));
//		}
//		System.out.println();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (fmap[i][j] == 'F') {
					for (int d = 0; d < 4; d++) {
						int y = i + dy[d];
						int x = j + dx[d];
						if (check(y, x) && map[y][x] != '#') {
							map[y][x] = 'F';
						}
					}
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

	private static boolean check(int y, int x) {
		if (y >= 0 && x >= 0 && y < R && x < C) {
			return true;
		}
		return false;
	}

	private static boolean jihun() { // 이동의 최소값.
		dead = 0;
		for (int d = 0; d < 4; d++) {
			if (!check(jy + dy[d], jx + dx[d])) {
				return false;
			}
			if (map[jy + dy[d]][jx + dx[d]] != '#' && map[jy + dy[d]][jx + dx[d]] != 'F') {
				jy += dy[d];
				jx += dx[d];	
				map[jy][jx] = 'J';
				break;
			} else {
				dead++;
			}
			if (dead == 4) {
				dead = -1;
				return false;
			}
		}
		return true;
	}

}
