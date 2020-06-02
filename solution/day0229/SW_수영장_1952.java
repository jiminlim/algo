package com.corona.day0229;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_수영장_1952 {
	static int T;
	static int[] arr, pay, month;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("수영장"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			pay = new int[4];
			month = new int[12];
			for (int i = 0; i < pay.length; i++) {
				pay[i] = Integer.parseInt(tk.nextToken());
			}
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < month.length; i++) {
				month[i] = Integer.parseInt(tk.nextToken());
			}
			// 입력완료
			arr = new int[5];
			arr[0] = only1day();
			arr[1] = only1month();
			arr[2] = dayAmonth();
//			month3();
			arr[4] = pay[3];

			Arrays.toString(arr);
			for (int a = 0; a < arr.length; a++) {
				System.out.print(arr[a] + " ");
			}
		}
	}

	private static int dayAmonth() {
		int sum = 0;
		int a = pay[1] / pay[0];
		for (int i = 0; i < month.length; i++) {
			if (month[i] == 0) {
				continue;
			}
			if (month[i] < a) {
				sum += month[i] * pay[0];
			} else {
				sum += pay[1];
			}
		}
		return sum;
	}

	private static int only1month() {
		int sum = 0;
		for (int i = 0; i < month.length; i++) {
			if (month[i] != 0)
				sum += pay[1];
		}
		return sum;
	}

	private static int only1day() {
		int sum = 0;
		for (int i = 0; i < month.length; i++) {
			sum += month[i] * pay[0];
		}
		return sum;
	}
}
