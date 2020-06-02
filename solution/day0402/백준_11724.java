package com.corona.day0402;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 백준_11724 {
	static ArrayList<Integer> list;
	static int[][] arr;
	static boolean[] visit;
	static int M, N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("b11724"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M][2];
		visit = new boolean[M];
		list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			if (n1 < n2) {
				arr[i][0] = n1;
				arr[i][1] = n2;
			} else {
				arr[i][1] = n1;
				arr[i][0] = n2;
			}

		} // 입력 완료

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][0] + " ");
		}
		System.out.println();

		int[] save = new int[M + 1];

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (!visit[i]) {
				list.add(arr[i][0]);
				list.add(arr[i][1]);
				visit[i] = true;
				System.out.println(i + " 번 돌았다");
				dfs(i, save);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int i, int[] save) {
		System.out.println(list.toString());
		if (list.isEmpty()) {
			return;
		}
		int num = list.remove(0);
		save[num]++;

		for (int j = i; j < M; j++) { // 만약 한번도 안갔고. 뺸값과 같다면
			if (!visit[j] && arr[j][0] == num) {
				visit[j] = true;
				if (save[arr[j][0]] == 0) {
					list.add(arr[j][0]);
				}
			}
		}
		dfs(i, save);
	}

}
