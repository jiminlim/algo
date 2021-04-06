package day0407;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16234_인구이동 {
	static int[][] map, copy;
	static int N, L,R;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0407/인구이동"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		L = Integer.parseInt(tk.nextToken());
		R = Integer.parseInt(tk.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		//입력끝
		
		//도시찾기
		int answer =0;
		while(true) {
			visit = new boolean[N][N];
			ArrayList<Point> list = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]){
						ArrayList<Point> nlist = new ArrayList<Point>();
						int newNum =bfs(i,j,map[i][j],1,nlist);
						if(newNum !=0) {
							for (Point point : nlist) {
								list.add(new Point(point.y, point.x, newNum));
							}
						}
					}
				}
			}
			//연합있냐
			if(list.size()==0) break; //연합없어
			for (Point point : list) {
				map[point.y][point.x]= point.num; 
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			answer ++;
		}
		System.out.println(answer);
		
	}
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static int bfs(int r, int c, int people, int cnt, ArrayList<Point> nlist) {
		boolean check[][] = new boolean[N][N];
		visit[r][c] = true;
		check[r][c] = true;
		Queue<Point> que = new LinkedList<Point> ();
		que.offer(new Point(r, c));
		while(!que.isEmpty()) {
			Point po= que.poll();
			for (int i = 0; i < dir.length; i++) {
				int ny =po.y + dir[i][0];
				int nx = po.x +dir[i][1];
				if(ny <0||nx<0|| ny>= N ||nx>=N) continue;
				if(check[ny][nx]) continue;
				int num = Math.abs(map[po.y][po.x]- map[ny][nx]);
				if(num < L || num > R) continue;
				check[ny][nx] = true; visit[ny][nx] = true;
				que.offer(new Point(ny, nx));
				cnt++; people += map[ny][nx];
				nlist.add(new Point(ny, nx));
			}
		}
		
		//copy에 check인곳 인구수 나눠서 넣어라 
		int newPeople = 0;
		if(nlist.size()!=0) {
			nlist.add(new Point(r,c));
			newPeople = people/cnt;
		}
		return newPeople;
	}
	static class Point{
		int y; int x; int num;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		public Point(int y, int x,int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}

	}
}
