package com.corona.day0505;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_17472_다리만들기2 {
	static int N, M;
	static int[][] map, ladder;
	static boolean[][] v;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0505/다리만들기"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int cnt = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					findIsland(i, j, cnt);
					cnt++;
				}
			}
		}
		print();
		ladder = new int[cnt-1][cnt-1]; //4x4 / 섬 4개 
		//사다리 찾기
		cnt =2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==cnt) {
					findladder(i,j,cnt);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		printl(cnt-2); //cnt-2 =4
		
		boolean check[] = new boolean[cnt-2];
		for (int i = 0; i < ladder.length; i++) {
			for (int j = i; j < ladder.length; j++) {
				
			}
		}
		
		
		
	}

	private static void findladder(int i, int j, int cnt) {
		//각섬에서 다른섬으로 갈수 있으면  y(cnt)축 시작섬-> x축 도착섬.
		//현재 위치에서 다른 섬 갈수 있는지
		for (int d = 0; d < 4; d++) {
			int ly = i+dy[d]; int lx = j+dx[d];
			if(check(ly,lx) && map[ly][lx]==0) {
				int len =0; boolean flag = false; 
				while(check(ly,lx) && map[ly][lx]==0) {
					ly +=dy[d]; lx +=dx[d]; //계속 d방향으로 전진.	
					len++;
					if(check(ly,lx) && map[ly][lx]!=0) {
						flag = true;
					}
				}
				if(flag) {//새로운 섬을 만나면
					if(map[cnt-2][map[ly][lx]-2]!=0) {
						len = Math.max(len, map[cnt-2][map[ly][lx]-2]);
					}
					if(len==1)len =0;
					ladder[cnt-2][map[ly][lx]-2]=len;
				}
			}
		}	
		
		for (int d = 0; d < 4; d++) { //다음위치 이동
			int ny = i+dy[d]; int nx = j+dx[d];
			if(check(ny,nx) && !v[ny][nx] && map[ny][nx]==cnt) {
				v[ny][nx]=true; 
				findladder(ny, nx, cnt);
				
			}
		}
		
	}


	private static boolean check(int ny, int nx) {
		if(ny<N && ny>=0 &&nx<M && nx>=0)
			return true;
		return false;
	}
	private static void findIsland(int i, int j, int cnt) {
		
		for (int d = 0; d < 4; d++) {
			int ny = i+dy[d]; int nx = j+dx[d];
			if(ny<N && ny>=0 &&nx<M && nx>=0 && map[ny][nx]==1) {
				map[ny][nx]=cnt;
				findIsland(ny, nx, cnt);
			}
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}		
	}
	private static void printl(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ladder[i][j] +" ");
			}
			System.out.println();
		}	
	}
}
