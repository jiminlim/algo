package com.corona.day0429;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_0450_재관이의대량할인 {
	static int TC, N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0429/재관대량할인"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(tk.nextToken());
			}
			int n = N % 3;
			int sum = 0;
			Arrays.sort(list);
			for (int i = 0; i < N; i++) {
				sum += list[i];
			}
			for (int i = n; i < N; i = i + 3) {
				sum -= list[i];
			}
			System.out.println("#" + tc + " " + sum);
		}

	}

}
