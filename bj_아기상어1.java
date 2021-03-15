package day0315;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_�Ʊ���1 {
	static int[][] map, dir = {{-1,0,},{1,0},{0,-1},{0,1}};
	static int time,N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0315/�Ʊ���"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Shark shark = new Shark(0, 0, 2, 0, 0);
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] == 9) {
					shark.y = i;
					shark.x = j;
					map[i][j] =0;
				}
			}
		}
		bfs(shark);
		System.out.println(time);
	}


	private static void bfs(Shark shark) {
		boolean[][] visit = new boolean[N][N];
		Queue<Shark> que = new LinkedList<Shark>();
		que.offer(shark);
		visit[shark.y][shark.x]=true;
		Shark s = null;
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		while(!que.isEmpty()) {
			int bfs_dept = que.size();
			for (int que_size = 0; que_size < bfs_dept; que_size++) {
				s = que.poll();
				
				for (int i = 0; i < 4; i++) {
					int ny = s.y+dir[i][0];
					int nx = s.x+dir[i][1];
					
					if(ny < 0|| ny>=N || nx<0 || nx >= N) continue;
					if(visit[ny][nx]) continue;
					visit[ny][nx]=true;
					
					if(map[ny][nx] == 0 || map[ny][nx] == s.size) {
						que.add(new Shark(ny, nx, s.size, s.dept +1, s.eatCnt));
					}else if(map[ny][nx] < s.size){ // ���� ���� �ִٹ�! 
						pq.offer(new Fish(ny, nx, map[ny][nx], s.dept+1));
					}
				}
			}
			if(!pq.isEmpty()) { // pq�� ���� ���� �����~!
				break;
			}
			
			
		}
		
		if(pq.isEmpty()) { //��� ����⸦ �� �����ߴµ� ���� ����Ⱑ ����. 
			return;
		}else { // ���� ����Ⱑ �ִ�. 
			Fish f = pq.poll(); 
			s.eat();//����⸦ ���� �� ����� ������ ���� ����� ��. 
			
			map[f.y][f.x]= 0;
//			print();
			time += f.dept;
			bfs(new Shark(f.y,f.x,s.size,0,s.eatCnt));
		}
		
	}


	static class Fish implements Comparable<Fish> {
		int y;
		int x;
		int size;
		int dept; // 
		
		public Fish(int y, int x, int size, int dept) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.dept = dept;
		}


		@Override
		public int compareTo(Fish f) {
			if (this.dept == f.dept) {
				if(this.y == f.y) {
					return this.x > f.x? 1: -1;
				} else 
					return this.y > f.y? 1: -1;
			}else 	
				return this.dept > f.dept? 1: -1;
		}

	}
	static class Shark {
		int y; int x; int size;
		int dept; int eatCnt;// (��� ������ ������ ���� )



		public Shark(int y, int x, int size, int dept, int eatCnt) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.dept = dept;
			this.eatCnt = eatCnt;
		}
		
		public void eat() {
			eatCnt++;
			if(eatCnt == size) {
				eatCnt =0;
				size ++;
			}
		}
		
	}
	
	
	private static void print() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

}
