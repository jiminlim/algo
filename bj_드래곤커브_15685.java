package day0323;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_µå·¡°ïÄ¿ºê_15685 {
	static int[][] map, input, dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static int K, cnt;
	static ArrayList<Integer> dlist;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0323/µå·¡°ïÄ¿ºê"));
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		map = new int[101][101];
		visit = new boolean[101][101];
		input = new int[K][4];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 4; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		dlist = new ArrayList<Integer>();
		cnt =0;
		for (int i = 0; i < K; i++) {
			map[input[i][1]][input[i][0]]=1;
			curb(input[i][1],input[i][0],input[i][2],input[i][3]);
			dlist.clear();
		}
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					visit[i][j] = true;
					find(i,j,1);
				}
			}
		}
		
		System.out.println(cnt);

	}

	private static void find(int y, int x, int n) {
		if(y+n<0 || y+n>= map.length || x+n<0 || x+n>=map.length) return;
		if(map[y][x+n] == 0) return;
		if(map[y+n][x] == 0) return;
		if(map[y+n][x+n]==0) return;
		cnt++;
	}

	private static void curb(int y, int x, int d, int g) {
//		System.out.println(y+" "+x);
		y+=dir[d][0];
		x+=dir[d][1];
//		System.out.println(y+" "+x);
		map[y][x]=1;
		dlist.add(d);
		for (int i = 0; i < g; i++) {
			int dlist_len = dlist.size();
//			System.out.println("g : "+i +" len :"+dlist_len);
			for (int j = dlist_len - 1; j >= 0; j--) {
				int di = dlist.get(j);
//				System.out.print(j+". "+di+" -> ");
				di++;
				di = di % 4;
				y += dir[di][0];
				x += dir[di][1];
//				System.out.println(di+" / "+y+" "+x);
				map[y][x] = 1;
				dlist.add(di);
			}
		}

	}

}
