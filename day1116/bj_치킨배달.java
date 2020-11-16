package day1116;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_치킨배달 {
	static int[][] map;
	static int N, M, result;
	static LinkedList<Position> hlist, clist;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/day1116/치킨"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());

		map = new int[N][N];
		hlist = new LinkedList<>();
		clist = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] == 1) {
					hlist.add(new Position(i, j, Integer.MAX_VALUE));
				} else if (map[i][j] == 2) {
					clist.add(new Position(i, j, Integer.MAX_VALUE));
				}
			}
		}

		result = Integer.MAX_VALUE;
		// m개만큼 골라 조합
		int[] combi = new int[M];
		if (M != clist.size()) {
			combi(combi, clist.size(), M, 0, 0);
		} else {
			for (int i = 0; i < combi.length; i++) {
				combi[i] = i;
			}
			distance(combi);
		}
		// 모든 치킨 거리 합
		
		System.out.println(result);

	}

	private static void distance(int[] combi) {
		
		for (int i = 0; i < combi.length; i++) {
			int len = 0;
			for (int j = 0; j < hlist.size(); j++) {
				len = Math.abs(clist.get(combi[i]).getY() - hlist.get(j).getY())
						+ Math.abs(clist.get(combi[i]).getX() - hlist.get(j).getX());
				int di = hlist.get(j).getD();
				if (di > len) {
					hlist.get(j).setD(len);
				}
			}
		}
		int sum =0;
		for (Position data : hlist) {
			sum += data.getD();
			data.setD(Integer.MAX_VALUE);
		}
		if(sum < result ) {
			result = sum;
		}
	}

	private static void combi(int[] combi, int n, int r, int start, int cnt) {
		if (cnt == r) {
			distance(combi);
			return;
		}
		for (int i = start; i < n; i++) {
			combi[cnt] = i;
			combi(combi, n, r, i + 1, cnt + 1);
		}

	}

	static class Position {
		int y;
		int x;
		int d;

		public Position(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getD() {
			return d;
		}

		public void setD(int d) {
			this.d = d;
		}

	}

}
