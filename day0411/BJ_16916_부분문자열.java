package com.corona.day0411;

import java.io.FileInputStream;
import java.util.Scanner;

public class BJ_16916_부분문자열 {
	static int cnt;

	static int[] getPi(String p) {// 패턴 구하기
		int[] pi = new int[p.length()];
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}

			if (p.charAt(j) == p.charAt(i)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static int KMP(String s, String p) {
		int[] pi = getPi(p);
		int j = 0;
		int cnt=0;
		for (int i = 0; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (s.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					return 1;
				} else {
					j++;
				}
			}
			System.out.println(j+" "+cnt);
			
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0411/부분문자열"));
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String p = sc.next();
		cnt = KMP(s, p);

		System.out.println(cnt);
	}

}
