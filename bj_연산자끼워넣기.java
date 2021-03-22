package day0317;

import java.util.Arrays;
import java.util.Scanner;

public class bj_연산자끼워넣기 {
	static int[] number, operator;
	static int N, min, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		operator = new int[4];
		for (int i = 0; i < 4; i++) {
			operator[i] = sc.nextInt();
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		dfs(1, number[0]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int i, int sum) {
		if (i >= N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}

		for (int j = 0; j < 4; j++) {
			if (operator[j] <= 0)
				continue;
			operator[j]--;
			dfs(i + 1, cal(sum, number[i], j));
			operator[j]++;
		}
	}

	private static int cal(int sum, int num, int j) {
		switch (j) {
			case 0: {
				sum = sum + num;
				break;
			}
			case 1: {
				sum = sum - num;
				break;
			}
			case 2: {
				sum = sum * num;
				break;
			}
			case 3: {
				if (sum < 0) {
					sum = (Math.abs(sum) / num) * (-1);
				} else {
					sum = sum / num;
				}
				break;
			}
		}
		return sum;
	}
}
