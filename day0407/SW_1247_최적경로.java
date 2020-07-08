package com.corona.day0407;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1247_최적경로 {
	static int tc, N;
	static int[] y, x, v;
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("최적경로"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= 1; t++) {
			N = Integer.parseInt(br.readLine());
			y = new int[N + 2];
			x = new int[N + 2];
			v = new int[N];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = N + 1; i >= 0; i--) {
				y[i] = Integer.parseInt(tk.nextToken());
				x[i] = Integer.parseInt(tk.nextToken()); // 뒤에서 부터 입력받음 좌표 / 집/ 회사 순서
			}
			System.out.println(Arrays.toString(y));
			System.out.println(Arrays.toString(x));

			max = 0;
			boolean check[] = new boolean[N];
			for (int i = 0; i < N; i++) {
				if (!check[i]) {
					check[i] = true;
					v[i] += Math.abs(y[i] - y[N + 1] + Math.abs(x[i] - x[N + 1]));
					System.out.println("--------------------------------------------------------------");
					System.out.println("start : " + i);
					dfs(y[i], x[i], 1, i);
					v[i] = 0;
					System.out.println("--------------------------------------------------------------");
				}
			}

		}
	}


	private static void dfs(int ay, int ax, int cnt, int a) {
		System.out.println(Arrays.toString(v) + " cnt = " + cnt);
		if (cnt == (N - 1)) {
			System.out.println("cnt====n " + Arrays.toString(v) + "\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i] == 0) {
				int abs = Math.abs(y[i] - ay) + Math.abs(x[i] - ax);
				System.out.println("abs         y[i]= " + y[i] + " ay= " + ay + " i= " + i + " a= " + a +" cnt =" +cnt);
				v[i] += abs;
				// System.out.println("i== "+i+" "+y[i]+","+ x[i] +" :::: "+v[i] +" abs= "+abs);
				dfs(y[i], x[i], cnt+1, i);
				v[i] = 0;
			}
		}
	}

}

/*
제출
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
    static int T, N, M;
    static int[][] p;
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tk.nextToken());
            M = Integer.parseInt(tk.nextToken());
            p = new int[N+1][N+1];
            v = new boolean[N+1];
            for (int i = 0; i < M; i++) {
                tk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(tk.nextToken());
                int b = Integer.parseInt(tk.nextToken());
                p[a][b] =1; p[b][a]=1;
            }
            int cnt=0;
            for (int i = 1; i < N+1; i++) {
                if (!v[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println("#"+t+" "+ cnt);
        }
    }
    private static void dfs(int i) {
        v[i]=true;
        for (int j = 1; j < N+1; j++) {
            if (!v[j] && p[i][j]==1) {
                dfs(j);
            }
        }
    }
}



 * */
