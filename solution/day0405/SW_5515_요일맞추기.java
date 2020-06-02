package com.corona.day0405;

import java.io.FileInputStream;
import java.util.Scanner;

public class SW_5515_요일맞추기 {
	static int T, m, d;
	static int[] week = { 0, 1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0405/요일"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			m = sc.nextInt();
			d = sc.nextInt();
			int i = 1;
			int day =0;
			System.out.println(m);
			while (i < m) {
				if (i == 2)
					day += 29;
				else if (i == 4 || i == 6 || i == 9 || i == 11)
					day += 30;
				else
					day += 31;
				i++;
			}
			day = day+d;
			System.out.println("#" + (t + 1) + " " + week[(day + 3) % 7]);
		}
	}

}
