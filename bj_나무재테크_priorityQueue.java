package day0317;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import day0317.bj_나무재테크_priorityQueue.Tree;

public class bj_나무재테크_priorityQueue {
	static int[][] map, food,
			dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	static int N, M, K;
	static PriorityQueue<Tree> tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0317/나무"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		food = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = 5;
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		tree = new PriorityQueue<Tree>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			tree.offer(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		// 사계절 시작
		while (K-- > 0) {
			ArrayList<Tree> dead = new ArrayList<Tree>(); // 죽음
			ArrayList<Tree> bread = new ArrayList<Tree>(); // 분열
			PriorityQueue<Tree> newpq = new PriorityQueue<Tree>();
			int pq_size = tree.size();
			for (int i = 0; i < pq_size; i++) {
				Tree t = tree.poll();
				if (t.year > map[t.y][t.x]) { // 양분 못먹음
					dead.add(new Tree(t.y, t.x, t.year));
					continue;
				}
				// 양분먹음
				newpq.offer(new Tree(t.y, t.x, t.year + 1));
				map[t.y][t.x] -= t.year;

				if ((t.year+1) % 5 == 0) { // 번식
					bread.add(new Tree(t.y,t.x,t.year+1));
				}
			}
			tree = new PriorityQueue<Tree>(newpq);
			
			for(Tree t : dead) {
				map[t.y][t.x] += t.year/2; 
			}
			dead.clear();
			
			for(Tree t: bread) {
				for (int i = 0; i < 8; i++) {
					int ny = t.y+dir[i][0];
					int nx = t.x + dir[i][1];
					
					if(ny<1 || ny> N || nx<1 || nx>N) continue;
					tree.add(new Tree(ny,nx,1));
				}
				
			}
			bread.clear();
			
			for(int r =1; r<N+1;r++) {
				for(int c=1; c<N+1;c++) {
					map[r][c] += food[r][c];
				}
			}
		}

		System.out.println(tree.size());
	}

	static class Tree implements Comparable<Tree> {
		int y;
		int x;
		int year;

		public Tree(int y, int x, int year) {
			this.y = y;
			this.x = x;
			this.year = year;
		}

		@Override
		public int compareTo(Tree t) {
			return this.year > t.year ? 1 : -1;
		}
	}
}
