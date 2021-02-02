package day0201;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class sw_미생물격리 {
	static int N, M, K;
	static int[][] dir = { { -1, 0 }, { 1,0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static LinkedList<Cell> map[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0201/미생물"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());

			map  =  new LinkedList[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] =  new LinkedList<Cell>();
				}
			}
			
//			Cell[][] map = new Cell[N][N];
			for (int i = 0; i < K; i++) {
				tk = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(tk.nextToken());
				int x = Integer.parseInt(tk.nextToken());
				int count = Integer.parseInt(tk.nextToken());
				int dir = Integer.parseInt(tk.nextToken());
				map[y][x].add( new Cell(count, dir-1));
			}

			LinkedList<Cell>[][] copy=null;
			for (int c = 0; c < M; c++) { // 시간 카운트
				// 1시간마다 이동
				copy =  new LinkedList[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						copy[i][j] =  new LinkedList<Cell>();
					}
				}
				
				//미생물 이동
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j].size() != 0) { // 미생물이 있다묜
							int ny = i + dir[map[i][j].get(0).dir][0];
							int nx = j + dir[map[i][j].get(0).dir][1];
							if (ny==0 || nx ==0 || ny== N-1 || nx ==N-1) { // 약품처리한곳이라면
								// 방향바꿈, 개수 절반
								map[i][j].get(0).count = map[i][j].get(0).count / 2;
								int d = map[i][j].get(0).dir;
								switch (d) {
								case 0: {
									map[i][j].get(0).dir = 1;break;
								}
								case 1: {
									map[i][j].get(0).dir = 0;break;
								}
								case 2 : {
									map[i][j].get(0).dir = 3;break;
								}
								case 3: {
									map[i][j].get(0).dir = 2;break;
								}
								}
							}
//							if (copy[ny][nx].size() != 0) { // 이동 공간에 미생물이 존재한다면
//								if(copy[ny][nx].count < map[i][j].count) {
//									copy[ny][nx].dir = map[i][j].dir; 
//								}
//								copy[ny][nx].count += map[i][j].count;
//							}else {
//								copy[ny][nx] = map[i][j];
//							}
							copy[ny][nx].add(map[i][j].get(0));
							
						}
					}
				}
				
				//미생물 합침
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(copy[i][j].size() > 1) {
							Cell ce = copy[i][j].get(0);
							int len =  copy[i][j].size();
							int sum =  ce.count;
							for (int k = 1; k < len; k++) {
								sum+=copy[i][j].get(k).count;
								if(ce.count < copy[i][j].get(k).count) {
									ce = copy[i][j].get(k);
								}
							}
							
							copy[i][j].removeAll(copy[i][j]);
							ce.count=sum;
							copy[i][j].add(ce);
						}
					}
				}
//				print(copy);
//				System.out.println(" ___ ");
				map = copy;
			}

			// 전체 미생물수 카운트
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].size() != 0)
						result += map[i][j].get(0).count;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void print(LinkedList<Cell>[][] copy) {
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(copy[i][j].size() ==0){
					System.out.print(0+" ");
				}else {
					System.out.print(copy[i][j].get(0).count+" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
}

class Cell {
	int count;
	int dir;

	public Cell(int count, int dir) {
		super();
		this.count = count;
		this.dir = dir;
	}
}
