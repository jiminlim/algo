package day0319;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class bj_마법사상어와토네이도 {
	static int N,windsand;
	static int[][] map, dir = {{0,-1},{1,0},{0,1},{-1,0}}; 
	static ArrayList<Wind> list0, list1, list2,list3;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0319/마상토네이도"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer tk ;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		list0 = new ArrayList<Wind>();
		list1 = new ArrayList<Wind>();
		list2 = new ArrayList<Wind>();
		list3 = new ArrayList<Wind>();
		windsand =0;
		save_wind();
		int y = N/2, x = N/2;
		int d =0, cnt=0, move =1;
		boolean flag = true;
		while(flag) {
			//소용돌이 이동
			if(d==4) d =0;
			if(cnt == 2) {
				cnt =0; move++;
			}
			for(int m =0; m <move; m++) {
				y+=dir[d][0]; x+=dir[d][1];
				if(y==0 && x==-1) {flag = false;break;} //1번으로 이동 후 끝남 = 한번더 돌아라임마
				if(map[y][x] > 0) {
					switch (d) {
					case 0: {
						wind(list0,y,x,d);
						break;
					}
					case 1:{
						wind(list1,y,x,d);
						break;
					}
					case 2:{
						wind(list2,y,x,d);
						break;
					}
					case 3:{
						wind(list3,y,x,d);
						break;
					}
					}
				}
			}
			cnt++;
			d++;
		}
		
		System.out.println(windsand);
	}
	
	
	private static void wind(ArrayList<Wind> list, int y, int x, int d) {
		int sand = map[y][x];
		int a = sand;
		for(Wind w : list) {
			int ny = y+w.y; int nx = x+w.x;
			int val = sand *w.percent / 100;
			if(ny <0 || ny>=N || nx <0 || nx >=N) {
				windsand += val;
			}else {
				map[ny][nx]+=val;
			}
			a -= val;
		}
		int r = y+dir[d][0]; int c = x+dir[d][1];
		if(r < 0 || r >=N || c < 0 || c >= N) {
			windsand += a;
		}else {
			map[r][c] += a;
		}
	}


	private static void save_wind() {
		//좌 list0
		list0.add(new Wind(-1,0,7));
		list0.add(new Wind(1,0,7));
		list0.add(new Wind(-2,0,2));
		list0.add(new Wind(2,0,2));
		list0.add(new Wind(-1,1,1));
		list0.add(new Wind(1,1,1));
		list0.add(new Wind(-1,-1,10));
		list0.add(new Wind(1,-1,10));
		list0.add(new Wind(0,-2,5));
		//하 list1
		list1.add(new Wind(0,1,7));
		list1.add(new Wind(0,-1,7));
		list1.add(new Wind(0,2,2));
		list1.add(new Wind(0,-2,2));
		list1.add(new Wind(-1,-1,1));
		list1.add(new Wind(-1,1,1));
		list1.add(new Wind(1,-1,10));
		list1.add(new Wind(1,1,10));
		list1.add(new Wind(2, 0, 5));
		//우 list2
		list2.add(new Wind(-1,0,7));
		list2.add(new Wind(1,0,7));
		list2.add(new Wind(-2,0,2));
		list2.add(new Wind(2,0,2));
		list2.add(new Wind(-1,1,10));
		list2.add(new Wind(1,1,10));
		list2.add(new Wind(-1,-1,1));
		list2.add(new Wind(1,-1,1));
		list2.add(new Wind(0,2,5));
		//상 list3
		list3.add(new Wind(0,1,7));
		list3.add(new Wind(0,-1,7));
		list3.add(new Wind(0,2,2));
		list3.add(new Wind(0,-2,2));
		list3.add(new Wind(-1,-1,10));
		list3.add(new Wind(-1,1,10));
		list3.add(new Wind(1,-1,1));
		list3.add(new Wind(1,1,1));
		list3.add(new Wind(-2, 0, 5));
	}

	
}
class Wind{
	int y; int x;
	int percent;
	
	public Wind(int y, int x, int percent) {
		super();
		this.y = y;
		this.x = x;
		this.percent = percent;
	}
}
