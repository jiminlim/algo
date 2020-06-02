package com.corona.day0405;

import java.util.Scanner;

public class BJ_13일금요일 {
	static int Y, cnt;

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		Y = sc.nextInt();
		Y=2021;
		
		int day = 1;
		for (int i = 0; i < Y - 2018; i++) {
			int j = 0;
			while (j++ < 12) {
				if (find(day)) {
					cnt++;
					print(i, j, day);
				}
				if (j == 2) {
					if (yun(i)) {
						day += 29;
					} else {
						day += 28;
					}
				} else if (j == 4 || j == 6 || j == 9 || j == 11) {
					day += 30;
				} else {
					day += 31;
				}

			}
		}
		System.out.println(cnt);
	}

	private static void print(int i, int j, int day) {
		i += 2019;
		char[] week = { '월','화','수','목','금','토','일' };
		
		System.out.println(i + "년 " + j + "월 " +week[(day) % 7] + "요일 "+(day) % 7);
	}

	private static boolean yun(int i) {
		int day = 2019 + i;
		if (day % 400 == 0)
			return true;
		else if (day % 100 == 0)
			return false;
		if (day % 100 == 0 && day % 4 == 0)
			return true;
		return false;
	}

	private static boolean find(int day) {
		// day가 13일이면
		day += 13;
		if ((day + 3) % 7 == 0) {
			return true;
		}
		return false;
	}

}
