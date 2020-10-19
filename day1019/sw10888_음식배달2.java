package day1019;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw10888_음식배달2 {
	static int N, answer;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<int[]> franchiseeLoc, houseLoc;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1019/음식배달"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
//		TC = 1;
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
			map = new int[N + 1][N + 1];
			franchiseeLoc = new ArrayList<>();
			houseLoc = new ArrayList<>();
			int numOfFran = 0;
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					int val = Integer.parseInt(tk.nextToken());
					map[i][j] = val;
					if (val != 0 && val != 1) {
						numOfFran++;
						franchiseeLoc.add(new int[] { i, j, val });
					}
				}
			}
//			System.out.println(numOfFran);

			// 프랜차이즈 갯수 조합
			for (int i = 1; i <= numOfFran; i++) {
				int[] franchisee = new int[i];
				findfranchise(numOfFran, i, 0, 0, franchisee);
			}

			System.out.println("#" + (tc + 1) + " " + answer);
		}

	}

	private static void findfranchise(int n, int r, int start, int cnt, int[] franchisee) {
		if (cnt == r) {
//			System.out.println(Arrays.toString(franchisee));
			// 나온 프랜차이즈 돌려서 최소값 구함
			int returnmin = findAnswer(franchisee);
			if (answer > returnmin) {
				answer = returnmin;
			}
			return;
		}

		for (int i = start; i < n; i++) {
			franchisee[cnt] = i;
			findfranchise(n, r, i + 1, cnt + 1, franchisee);
		}
	}

	private static int findAnswer(int[] franchisee) {
		boolean[][] vmap = new boolean[N + 1][N + 1];
		int returnval = 0;
//		System.out.println(Arrays.toString(franchisee));
		// bfs
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < franchisee.length; i++) {
			int[] floc = franchiseeLoc.get(franchisee[i]);
			que.add(new int[] { floc[0], floc[1], franchisee[i] });
			vmap[floc[0]][floc[1]] = true;
			returnval+= floc[2];
		}

		int size = que.size();

		while (!que.isEmpty()) {
			int len =0;
			for (int s = 0; s < size; s++) {
				int[] loc = que.poll();
				for (int j = 0; j < 4; j++) {
					int ny = loc[0] + dir[j][0];
					int nx = loc[1] + dir[j][1];

					if (check(ny, nx) && !vmap[ny][nx]) {
						if (map[ny][nx] == 1) {
							int[] floc = franchiseeLoc.get(loc[2]);
							int d = Math.abs(ny - floc[0]) + Math.abs(nx - floc[1]);
							returnval += d;
//							System.out.println(floc[0]+" "+floc[1]+" / "+ny+" "+nx +" / "+d);
						}
						que.add(new int[] { ny, nx, loc[2] });
						vmap[ny][nx] = true;
						len++;
					}
				}

			}
			size = len;
		}
		

		return returnval;
	}

	private static boolean check(int ny, int nx) {
		if (ny > 0 && nx > 0 && ny < N + 1 && nx < N + 1) {
			return true;
		}
		return false;
	}

}
