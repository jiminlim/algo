package day0317;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj_나무재테크 {
	static int[][] map,food, dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
	static ArrayList<Integer> tree[][];
	static int N,M,K;
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

		tree = new ArrayList[N+1][N+1];
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				tree[i][j] = new ArrayList<Integer>();
			}
		}
		//입력 완료
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			tree[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		//사계절 시작
		while(K-- > 0) {
			ArrayList<Tree> list = new ArrayList<Tree>();
			for (int r = 1; r < N+1; r++) {
				for (int c = 1; c < N+1; c++) {
					int dead = 0;
					if(tree[r][c].size()>0) {//나무가 있다면
						//봄
						Collections.sort(tree[r][c]);
//						int num =0;
						int tree_size = tree[r][c].size();
						for(int i =0; i < tree_size; i++) { //작은 나이부터 양분 냠냠
							int year = tree[r][c].get(0);
							tree[r][c].remove(0);
							if(year > map[r][c]) { // 여름 - 양분 못먹엉.
								dead += year/2; 
							}else { // 양분 냠냠
								map[r][c] -= year;
								list.add(new Tree(r,c,year+1)); //나이증가
								if((year+1) % 5 == 0) { //가을 - 번식 // 여름까지 살아남은 나무
									for (int d = 0; d < 8; d++) {
										int ny = r+ dir[d][0];
										int nx = c+ dir[d][1];
										if(ny<=0 || ny>N || nx<=0 || nx>N) continue;
										list.add(new Tree(ny, nx, 1));
									}
								}
							}
							
						}
						
					}
					
					// 겨울 - 로봇이 양분 추가
					map[r][c] += food[r][c]+ dead;	
					
				}
			}
			for (Tree t: list) {
				tree[t.y][t.x].add(t.year);
			}
//			print();
		}
		int cnt =0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1;j++) {
				cnt += tree[i][j].size();
			}
		}
		
		System.out.println(cnt);
	}
	static class Tree{
		int y ; int x; int year;
		public Tree(int y, int x, int year) {
			this.y = y; this.x = x; this.year = year;
		}
	}
}
