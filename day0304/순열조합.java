package com.corona.day0304;

import java.util.Scanner;

public class 순열조합{
	static int N; // 던진 횟수
	static int M; // 출력 모양
	static int[] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[N];

		switch (M) {
		case 1:
			first(6, N, 0); //중복 허용 순열 = 모든 경우의 수
			break;
		case 2:
			second(6, N, 0, 0);//중복 허용 조합
			break;
		case 3:
			third(6, N, 0, 0); // 순열
			break;
		case 4:
			fourth(6,N,0,0); //조합
			break;
		default:
			System.out.println("1~4 사이값 입력해라");
			break;
		}
	}


	private static void first(int n, int r, int count) {
		if (r == count) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[count] = i + 1;
			first(n, r, count + 1);
		}
	}
	private static void third(int n, int r, int flag, int count) {
		
		if (r == count) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			
			if ((flag & 1 << i) == 0) {
				arr[count] = i + 1;
				third(n, r, flag | 1 << i, count + 1);
			}
		}
		
	}

	public static void second(int n, int r, int start, int count) {
		if (r == count) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			arr[count] = i + 1;
			second(n, r, i, count + 1);
		}

	}

	
	private static void fourth(int n, int r, int start, int count) {
		if (count == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			arr[count] = i + 1;
			fourth(n, r, i + 1, count + 1);
		}
	}
}
