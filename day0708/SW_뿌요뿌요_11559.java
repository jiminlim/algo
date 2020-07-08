package day0708;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_뿌요뿌요_11559 {
	static char[][] map, copy;
	static int cnt ,remove;
	static boolean[][] check;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0708/뿌요뿌요"));
		map = new char[12][6];
		copy = new char[12][6];
		
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		boolean nothing = false; // 하나도 할게 없다!
		boolean go = true;
		int result = 0;
		while (go) {
			 remove =0;
			 check = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!check[i][j] & map[i][j] != '.') {
						nothing = true;
						remove = findbbuyo(i, j);
					}
				}
			}
			if(remove==0) {
				go = false;
			}else {
//				제거했으면 중력적용
//				System.out.println("뿌요! "+remove);
				for (int i = 0; i < remove; i++) {
					char[] arr = new char[12];
					for (int j = 0; j < 6; j++) {
						Arrays.fill(arr, '.');
						int des = 11; 
						for (int k = 11; k >=0; k--) {
							if(map[k][j]!='.') {
								arr[des]=map[k][j];
								des--;
							}
						}
						
						for (int k = 0; k < 12; k++) {
							map[k][j]=arr[k];
						}
						
					}
				}
				print(map);
				result++;
			}
		}
		if (!nothing) {
			System.out.println(0);
		} else {
			// 뿌요 연타 출력
			System.out.println(result);
		}
	}

	private static int findbbuyo(int y, int x) {
		//전체맵 copy
		cnt =0;
		for (int a = 0; a < 12; a++) {
			System.arraycopy(map[a], 0, copy[a], 0, 6);
		}
		//dfs 
		dfs(y,x,map[y][x]);
		if(cnt<3) {
			for (int a = 0; a < 12; a++) {
				System.arraycopy(copy[a], 0, map[a], 0, 6);
			}
		}else {
			remove ++;
		}
		return remove;
	}

	private static void dfs(int y, int x, char color) {
		map[y][x] = '.';
		check[y][x] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y+dir[d][0]; int nx = x +dir[d][1];
			if(wall(ny,nx) && !check[ny][nx] && map[ny][nx]== color) {
				check[ny][nx] = true;
				cnt++;
				dfs(ny,nx,color);
			}
		}
	}

	
	
	private static boolean wall(int ny, int nx) {
		if(ny>=0 && nx>=0 && ny<12 && nx<6) return true;
		return false;
	}
	
	
	private static void print(char[][] map) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
