package com.corona.day0304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 지희계싼기 {
	static int T, S, cnt;
	static int[] num, po, bu;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("지희계산기"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			num = new int[10];
			for (int i = 0; i < 10; i++) {
				num[i] = Integer.parseInt(tk.nextToken());
				if (num[i] != 0) {
					cnt++;
				}
			}
			S = Integer.parseInt(br.readLine());
			po = new int[cnt];
			System.out.println(S);
			int k = 0;
			for (int i = 0; i < 10; i++) {
				if (num[i] != 0) {
					po[k] = i;
					k++;
				}
			}
			for (int i = 1; i < cnt; i++) {
				int[] arr = new int[i];
				perm(arr, i, 0, 0);
			}

			System.out.println("#" + t + " ");
		}
	}

	private static void perm(int[] arr, int r, int start, int count) {
		if (r == count) {
			String a = "";
			for (int i = 0; i < arr.length; i++) {
				a += arr[i] + "";
			}
			System.out.println(a);
			if (!flag && Integer.parseInt(a) <= S) {
				flag = calc(Integer.parseInt(a));
			}
			return;
		}
		for (int j = start; j < cnt; j++) {
			arr[count] = po[j];
			perm(arr, r, j + 1, count + 1);
		}
	}

	private static boolean calc(int v) {
		boolean fa = false;
		if (S % v == 0) { // 나누어지면
			int c = S / v;
			while (!fa) {
				if (c < 10) {
					
					break;
				}
				c = c / 10;
			}
		}
		return false;
	}

}
