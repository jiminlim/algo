package day0331;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_»ó¹üºôµù {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0331/ºôµù"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(tk.nextToken());
			int R = Integer.parseInt(tk.nextToken());
			int C = Integer.parseInt(tk.nextToken());
			if(L==0 && R==0 &&C==0) break;
			char[][][] map = new char[L][R][C];
			boolean[][][] visit = new boolean[L][R][C];
			int[][] dir = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
			String str ;
			int[] start = new int[3];
			int[] end = new int[3];
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					str = br.readLine();
					for (int c = 0; c < C; c++) {
						map[l][r][c] = str.charAt(c);
						if(str.charAt(c)=='S') {
							start[0] = l;
							start[1] = r;
							start[2] = c;
						}
						if(str.charAt(c)=='E') {
							end[0] = l;
							end[1] = r;
							end[2] = c;
						}
					}
				}
				str = br.readLine();
			}
			Queue<Point> que = new LinkedList<Point>();
			que.add(new Point(start[0], start[1], start[2]));
			visit[start[0]][start[1]][start[2]]=true;
			boolean flag = false;
			int time =0;
			loop:while(!que.isEmpty()) {
				int size = que.size();
				for (int s = 0; s < size; s++) {
					Point po = que.poll();
					for (int d = 0; d < 6; d++) {
						int nl = po.l + dir[d][0];
						int nr = po.r + dir[d][1];
						int nc = po.c + dir[d][2];
						if(nl < 0 || nl>= L || nr <0 || nr >=R || nc <0 || nc>=C)continue;
						if(map[nl][nr][nc]=='#') continue;
						if(map[nl][nr][nc]=='E') {
							flag = true;
							time++;
							break loop;
						}
						if(visit[nl][nr][nc]) continue;
						que.add(new Point(nl,nr,nc));
						visit[nl][nr][nc]=true;
					}
				}
				time++;
			}
			if(flag) System.out.println("Escaped in "+time+" minute(s).");
			else System.out.println("Trapped!");
		}
		
	}
	static class Point{
		int l; int r; int c;

		public Point(int l, int r, int c) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}

}
