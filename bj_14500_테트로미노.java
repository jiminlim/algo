package day0118;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14500_테트로미노 {
	static int[][] map;
	static int N, M, max;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] vi;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0118/테트"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		max = 0;

		vi = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				System.out.println(">>>>  "+i+" "+j+" /"+map[i][j]);
				vi[i][j] = true;
				dfs(i, j, 0, map[i][j]);
				vi[i][j] = false;
				max = Math.max(max, type2(i, j));
			}
		}
		System.out.println(max);
	}

	private static int type2(int i, int j) {
		int down = 0;
		boolean df = false;
		int right = 0;
		boolean rf = false;
		for (int k = 0; k < 3; k++) {
			if (!df && check(i + k, j)) {
				down += map[i + k][j];
			} else {
				df = true;
			}
			if (!rf && check(i, j + k)) {
				right += map[i][j + k];
			} else {
				rf = true;
			}
		}
		if (!df) {
			int a =0,b=0;
			if(j - 1 >= 0) {
				a = down + map[i + 1][j - 1];
			}
			if(j + 1 < M) {
				b = down + map[i + 1][j + 1];
			}
			
			down = Math.max(a, b);
		}
		if (!rf ) {
			int a =0,b=0;
			if(i - 1 >= 0) {
				a = right + map[i - 1][j + 1];
			}
			if(i+1<N) {
				b = right + map[i + 1][j + 1];
			}
			right = Math.max(a, b);
		}
		int sum = Math.max(down, right);
		return sum;
	}

	private static void dfs(int i, int j, int block, int sum) {
		if (block == 3) {
//			System.out.println();
			max = Math.max(max, sum);
//			System.out.println(sum+" "+max);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int ni = i + dir[k][0];
			int nj = j + dir[k][1];
			if (check(ni, nj) && !vi[ni][nj]) {
//				System.out.print( ni+" "+nj+"   /  ");
				vi[ni][nj] = true;
				dfs(ni, nj, block + 1, sum += map[ni][nj]);
				sum -= map[ni][nj];
				vi[ni][nj] = false;
			}
		}

	}

	private static boolean check(int i, int j) {
		if (i < N && i >= 0 && j < M && j >= 0)
			return true;
		return false;
	}

}
