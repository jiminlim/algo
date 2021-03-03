package day0303;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sw_방향전환_8382 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, // 세로
			{ 0, -1 }, { 0, 1 } };// 가로
	static int min, y2, x2;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0303/방향전환"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int x1 = sc.nextInt() + 100;
			int y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;
			min = Integer.MAX_VALUE;
			
			bfs1(y1,x1,true);
			bfs1(y1,x1,false);
			
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void bfs1(int y1, int x1, boolean f) {
		visit = new boolean[201][201];
		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(y1,x1,0, f));
		visit[y1][x1]=true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				Point po = que.poll();
				if(po.y == y2 && po.x == x2) {
					min = Math.min(min, po.cnt);
				}
				int a = 0; int b =2;
				if(!po.flag) {
					a=2; b=4;
				}
				for (int i = a; i < b; i++) {
					int ny = po.y + dir[i][0];
					int nx = po.x + dir[i][1];
					if(ny< 0 || ny>= 201 || nx<0 || nx>=201) continue;
					if(!visit[ny][nx]) {
						visit[ny][nx] = true;
						que.add(new Point(ny, nx, po.cnt+1, !po.flag));
					}
				}
			}
		}
	}

}
class Point{
	int y ; int x; int cnt; boolean flag;
	
	public Point(int y, int x, int cnt, boolean flag) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.flag = flag;
	}
	
}
