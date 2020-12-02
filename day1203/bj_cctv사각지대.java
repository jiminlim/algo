package day1203;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_cctv사각지대 {
	static int[] dir;
	static int n, N, M, result;
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, map, deep;
	static List<int[]> list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1203/cctv"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		map = new int[N][M];
		deep = new int[N][M];
		int val = 0;
		result =0;
		list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				val = Integer.parseInt(tk.nextToken());
				if (val != 0 && val != 6) {
					list.add(new int[] { i, j, val });
				}
				map[i][j]=val;
			}
		}
		// 5제외
		boolean flag =false;
		if(list.size()>1 ) {
			List<Integer> ali = new ArrayList<Integer>();
			for (int i=0;i<list.size();i++) {
				int[] arr =list.get(i);
				if(arr[2]==5) {
					for (int k = 0; k < 4; k++) {
						go(map,arr[0], arr[1], d[k][0], d[k][1]);
					}
//					list.remove(arr);
					ali.add(i);
				}
			}
			
			for (int i = ali.size()-1;i>=0 ;i--) {
				ali.remove(i);
			}
//			for (int iii = 0; iii < N; iii++) {
//				System.out.println(Arrays.toString(map[iii]));
//			}System.out.println();
		}else if(list.size()==1){
			int[] arr = list.get(0);
			if(arr[2]==5) {
				for (int k = 0; k < 4; k++) {
					go(map,arr[0], arr[1], d[k][0], d[k][1]);
				}
				
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 0) {
							result++;
						}
					}
				}
				flag = true;
			}
		}
		
		// 가짓수 찾기 재귀-> cnt로 가짓수 만큼.
		if(!flag) {
			result = Integer.MAX_VALUE;
			n = list.size();
			dir = new int[n];
			permu(0);
		}

		System.out.println(result);
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < M)
			return true;
		return false;
	}

	private static void permu(int cnt) {
		if (cnt == n) {
	
			// map 복사.
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, deep[i], 0, M);
			}
			simul();
			// 갯수 세기
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (deep[i][j] == 0) {
						count++;
					}
				}
			}
//			if(dir[0]==3 && dir[1]==3 && dir[6]==1)
//			{System.out.println(Arrays.toString(dir));
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(deep[i]));
//			}System.out.println();}
			
			result = Math.min(count, result);

			return;
		}
		for (int i = 0; i < 4; i++) {
			dir[cnt] = i + 1;
			permu(cnt + 1);
		}
	}

	private static void go(int[][] map, int i, int j, int k, int l) {
		int ny = i + k;
		int nx = j + l;
		while (check(ny, nx) && map[ny][nx] != 6) {
			if (map[ny][nx] == 0)
				map[ny][nx] = 7;
			ny = ny + k;
			nx = nx + l;
		}
	}

	private static void simul() {
		int ny = 0, nx = 0, k = 0;
		for (int i = 0; i < n; i++) {

			int[] arr = list.get(i);

			switch (arr[2]) {
			case 1: { // 한방향
				k = dir[i] - 1;
				go(deep ,arr[0], arr[1], d[k][0], d[k][1]);
				break;
			}
			case 2: { // 좌우
				k = dir[i] - 1;
				go(deep ,arr[0], arr[1], d[k][0], d[k][1]);
				go(deep ,arr[0], arr[1], -d[k][0], -d[k][1]);
				break;
			}
			case 3: { // 직각
				k = dir[i] - 1;
				go(deep ,arr[0], arr[1], d[k][0], d[k][1]);
				int kk = k + 1;
				if (kk == 4)
					kk = 0;
				go(deep ,arr[0], arr[1], d[kk][0], d[kk][1]);
				break;
			}
			case 4: { // 세방향
				k = dir[i] - 1;
				go(deep ,arr[0], arr[1], d[k][0], d[k][1]);
				go(deep ,arr[0], arr[1], -d[k][0], -d[k][1]);
				int kk = k + 1;
				if (kk == 4)
					kk = 0;
				go(deep ,arr[0], arr[1], d[kk][0], d[kk][1]);

				break;
			}
			}
		}
	}

}