package com.corona.day0603;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_시험감독_13458 {
	static int N, B, C;
	static long[] a;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0603/시험감독"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		a = new long[N];
		StringTokenizer tk1 = new StringTokenizer(br.readLine());
		StringTokenizer tk2 = new StringTokenizer(br.readLine());
		B = Integer.parseInt(tk2.nextToken());
		C = Integer.parseInt(tk2.nextToken());
		long gamdok = N;
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(tk1.nextToken()) - B;
			if (a[i] > 0) {
				if (a[i] % C != 0) {
					gamdok++;
				}
				gamdok += (a[i] / C);
			}
		}

		System.out.println(gamdok);
	}
}
