package com.corona.day0307;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW_화섭이의미생물 {

	public static int E, S, T, A, B;
	public static String[] sn;
	public static int[] tm;
	static int min;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("화섭미생물"));
		Scanner scann = new Scanner(System.in);
		E = scann.nextInt();

		for (int iT = 1; iT <= E; iT++) {
			S = scann.nextInt();
			T = scann.nextInt();
			A = scann.nextInt();
			B = scann.nextInt(); 
			min = Integer.MAX_VALUE;
			if (B == 1) {
				if ((T - S) % A == 0) {
					min = (T - S) / A;
				} else {
					min = Integer.MAX_VALUE;
				}
			} else {
				dfs(T, 0);
			}

			System.out.print("#"+iT+" ");
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		}
	}

	public static void dfs(int t3, int count) {
		if (t3 == S) {
			System.out.println(count
					);
			if (min > count) {
				
				min = count;
			}
			return;
		}
		if (t3 < S) {
			return;
		}
		if (t3 % B == 0) {
			if (t3 / B < S) {
				dfs(t3 - A, count + 1);
			} else {
				dfs(t3 / B, count + 1);
			}
		} else {
			dfs(t3 - A, count + 1);
		}
	}
}
