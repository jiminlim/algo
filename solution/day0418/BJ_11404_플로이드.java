package com.corona.day0418;

import java.io.FileInputStream;
import java.util.Scanner;

public class BJ_11404_플로이드 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0418/11404"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			if (map[a][b] > c)
				map[a][b] = c;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < n; j++) {
					if (j == k || j == i)
						continue;
					if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE)
						map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == Integer.MAX_VALUE) map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
