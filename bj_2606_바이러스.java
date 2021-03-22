package day0322;

import java.util.Scanner;

public class bj_2606_바이러스 {
	static int N, map[][];
	static boolean v[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		v = new boolean[N + 1];

		int network = sc.nextInt();
		for (int i = 0; i < network; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}

		v[1] = true;
		virus(1);
		
		int result =0;
		for (int i = 2; i <= N; i++) {
			if(v[i]) result ++;
		}
		System.out.println(result);
	}

	private static void virus(int s) {
		for(int i = 1; i<= N; i++) {
			if(map[s][i] ==1 && !v[i]) {
				v[i] = true;
				virus(i);
			}
		}
	}

}
