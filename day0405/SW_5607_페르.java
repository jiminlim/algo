package com.corona.day0405;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5607_페르 {
	static int T, n, r, p = 1234567891;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("페르마"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			r = Integer.parseInt(tk.nextToken());
			long fac[] = new long[n + 1];
			fac[0] = 1;
			for (int i = 1; i <= n; i++)
				fac[i] = (fac[i - 1] * i) % p;

			long down = fac[r] * fac[n - r] % p;
			down = fermat(down, p - 2);
			System.out.println("#" + t + " " + (fac[n] * down % p));
		}

	}

	private static long fermat(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = fermat(n, x / 2);
		long ret = (tmp * tmp) % p;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % p;
	}
}
