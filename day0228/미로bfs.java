package com.corona.day0228;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로bfs {
	static int N;
	static int[][] map;
	static int y,x, ey,ex;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] visited;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("미로bfs"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 16;
		StringBuilder sb;
		for (int t = 1; t <= 10; t++) {
			int k = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				sb = new StringBuilder();
				sb.append(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=sb.charAt(j)-'0';
					if (map[i][j]==2) {
						y = i; x=i;
					}
					if (map[i][j]==3) {
						ey=i; ex =j;
					}
				}
			}
			
			Queue<int[]> que = new LinkedList<int[]>();
			que.offer(new int[] { y, x });
			visited[y][x] =2;
			int end =0;
			while(!que.isEmpty()) {
				int[] yx = que.poll();
				if (yx[0]==ey && yx[1]==ex) {
					end =1;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int ddy=yx[0]+dy[d];
					int ddx = yx[1]+dx[d];
					if (save(ddy,ddx) && visited[ddy][ddx]!=2 &&map[ddy][ddx]==0 || map[ddy][ddx]==3 ) {
						visited[ddy][ddx]=2;
						que.add(new int[] {ddy,ddx});
					}
				}
			}
			
			
			System.out.println("#"+k+" "+end);
		}
		
	}
	private static boolean save(int ddy, int ddx) {
		if(ddy>=0 && ddx>=0 && ddy<16 && ddx<16)
			return true;
		return false;
	}

}
