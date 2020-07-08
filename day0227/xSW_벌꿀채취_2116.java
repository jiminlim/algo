package com.corona.day0227;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class xSW_벌꿀채취_2116 {
	static int T, N, M, C;
	static int[][] map;
	static int[][] max, honey;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("벌꿀체취"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			C = Integer.parseInt(tk.nextToken());
			map = new int[N][N];
			max = new int[M][3];
			honey = new int[N][N];
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(tk.nextToken());
				for (int j = 1; j < N; j++) {
					map[i][j] = Integer.parseInt(tk.nextToken());
					if (map[i][j] + map[i][j - 1] <= C) {
						int h1 = (int) Math.pow(map[i][j], 2);
						int h2 = (int) Math.pow(map[i][j - 1], 2);
						int sum = h1 + h2;
						honeyAdd(sum, i, j);
					} else {
						int sum = (int) Math.pow(Math.max(map[i][j], map[i][j - 1]), 2);
						honeyAdd(sum, i, j);
					}
				}
			}
			// max[0]- max값/ max[1] y / max[2] x
			Set<Integer> set = new HashSet<Integer>();
			Iterator<Integer> it = set.iterator();
			int cnt=0;
			for (int k = 0; k < M; k++) {
				set.add(cnt--);
			}
			System.out.println(set);
			System.out.println();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					while(it.hasNext()) {
						if (it.next()<honey[i][j]) {
							set.remove(it.next());
							set.add(honey[i][j]);
						}
					}
				}
			}

//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < 3; j++) {
//					System.out.print(max[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(honey[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

	private static void honeyAdd(int sum, int i, int j) {
		if (honey[i][j - 1] < sum) {
			honey[i][j] = sum;
			honey[i][j - 1] = sum;
		} else {
			honey[i][j] = sum;
		}
	}

}
