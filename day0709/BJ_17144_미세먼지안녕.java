package day0709;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {
	static int R,C,T;
	static int[][] map,copy,airClearLoc;
	static int[][] dir= {{0,1},{-1,0},{0,-1},{1,0}};//우상좌하
	static int[] windUp = {0,1,2,3};
	static int[] windDown = {0,3,2,1};
	static Queue<int[]> que;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0709/미세먼지안녕"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		T = Integer.parseInt(tk.nextToken());
		map = new int[R][C];
		copy = new int[R][C];
		airClearLoc = new int[2][2];
		int a =0;
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if(map[i][j]==-1) {
					airClearLoc[a][0]=i;
					airClearLoc[a][1]=j;
					a++;
				}
			}
		}
		que = new LinkedList<>();
		//T초만큼 돈다
		for (int time = 0; time < T; time++) {
			//계산할 맵 초기화
			newMap();
			//미세먼지 que에 넣음 
			addque();
			//공기확장
			while(!que.isEmpty()) {
				int[] loc = que.poll();
				int y = loc[0]; int x = loc[1];
				int divDust = map[y][x]/5; //확장되는 먼지양
				int dirCnt = 0; //확장방향 카운트
				for (int d = 0; d < 4; d++) {
					int ny = y+dir[d][0]; int nx = x+dir[d][1];
					if(check(ny,nx) && map[ny][nx]!=-1 ) {//사방에 공기청정기,벽이 아니면 true?
						dirCnt++;
						copy[ny][nx]+=divDust;
					}
				}
				copy[y][x] = map[y][x] - (divDust*dirCnt) + copy[y][x];
			}
			
			//copyMap을 map으로 
			for (int i = 0; i < R; i++) {
				System.arraycopy(copy[i], 0, map[i], 0, C);
			}
			//공기청정기 한번 가동.
			airClear();
			
		}
		
		//남은 양 출력
		int result =0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += map[i][j];
			}
		}
		
		System.out.println(result+2);
	}
	private static void airClear() {
		int[] up = new int[2];
		up[0]=airClearLoc[0][0]; up[1] = airClearLoc[0][1];
		int[] down = new int[2];
		down[0]=airClearLoc[1][0]; down[1] = airClearLoc[1][1];
		boolean go = true;
		int ny= 0, nx =0, cnt =0,first=0, second =0;
		
		while(go) { 
		//	System.out.println(up[0]+" "+up[1]+" / "+cnt);
			ny = up[0]+dir[windUp[cnt]][0]; nx = up[1]+dir[windUp[cnt]][1]; // 다음에 들어갈수
			if(map[up[0]][up[1]]==-1) {//시작할때
				first = map[ny][nx];//다음 꺼 임시저장
				map[ny][nx]=0;
				up[0]=ny; up[1]=nx; //다음꺼 현재위치로 
			}else if(!check(ny,nx)) { //벽이야
				cnt++;
			}else if(map[ny][nx]==-1) { //공기청정기에 닿았어
				go = false;
			}else {
				second = map[ny][nx];//다음 꺼 임시저장
				map[ny][nx]=first;
				first=second;
				up[0]=ny; up[1]=nx; //다음꺼 현재위치로 
			}
		}
		cnt=0;
		first =0; second=0; go = true;
		while(go) { 
				ny = down[0]+dir[windDown[cnt]][0]; nx = down[1]+dir[windDown[cnt]][1]; // 다음에 들어갈수
				if(map[down[0]][down[1]]==-1) {//시작할때
					first = map[ny][nx];//다음 꺼 임시저장
					map[ny][nx]=0;
					down[0]=ny; down[1]=nx; //다음꺼 현재위치로 
				}else if(!check(ny,nx)) { //벽이야
					cnt++;
				}else if(map[ny][nx]==-1) { //공기청정기에 닿았어
					go = false;
				}else {
					second = map[ny][nx];//다음 꺼 임시저장
					map[ny][nx]=first;
					first=second;
					down[0]=ny; down[1]=nx; //다음꺼 현재위치로 
				}
			}
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------출력!------");
	}
	private static boolean check(int ny, int nx) {
		if(ny>=0 && nx>=0 && ny<R && nx<C) return true;
		return false;
	}
	private static void newMap() {
		for (int i = 0; i < R; i++) {
			Arrays.fill(copy[i], 0);
		}
		copy[airClearLoc[0][0]][airClearLoc[0][1]]=-1;
		copy[airClearLoc[1][0]][airClearLoc[1][1]]=-1; 
	}
	private static void addque() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]!=0 && map[i][j]!=-1) {
					que.offer(new int[] {i,j});
				}
			}
		}
	}

}
