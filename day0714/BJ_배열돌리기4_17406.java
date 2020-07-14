package day0714;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_배열돌리기4_17406 {
	static int R,C,N;
	static int[][] map, dir = {{1,0},{0,1},{-1,0},{0,-1}};//하우상좌
	static int[] arr;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0714/배열돌리기4"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		map = new int[R][C];
		arr = new int[3];
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j]=Integer.parseInt(tk.nextToken());
			}
			
			
			//arr[0]-arr[2], arr[1]-arr[2] ~ arr[0]+arr[2], arr[1]+arr[2]
			int y = arr[0]-arr[2]-1, x = arr[1]-arr[2]-1; //시작위치
			int yy = arr[0]+arr[2]-1, xx = arr[1]+arr[2]-1; //끝위치
			
			while(trun(y,x,yy,xx)) {
//				System.out.println("------"+y+" "+x+" / "+yy+" "+xx);
				int r = yy-y+1; int c = xx-x+1; //작은 배열 행,열
				int ny=0,nx=0, first = map[y][x],temp =0, temp1=0;
				boolean go = true;
				for (int j = 0; j < 4; j++) {
					go = true;
					while(go) {
						ny = y+dir[j][0]; nx = x+dir[j][1];
//						System.out.println(ny+" "+nx+" / "+r+" "+c+" /"+(yy+1)+" "+(xx+1));
						if(check(ny,nx,r,c,yy+1,xx+1)) {
							map[y][x] = map[ny][nx];
							y = ny ; x= nx;
						}else {
							go = false;
						}
					}
				}
				map[y][x+1]=first;
				
				y++;x++; yy--;xx--;
			
			}
		}
		print();
		//배열의 각행 중 최솟값 출력
		int[] sums = new int[R];
		int result =Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < C; j++) {
				sums[i]+=map[i][j];
			}
			if(result>sums[i]) {
				result = sums[i];
			}
		}
		System.out.println(result);
		
		
	}
	private static boolean trun(int y, int x, int yy, int xx) {
		if(yy-y<=0 || xx-x<=0) return false;
		return true;
	}
	private static boolean check(int ny, int nx, int r, int c, int i, int j) {
		if(ny>=(i-r) && nx>=(j-c) && ny<i && nx<j) {
			return true;}
		return false;
	}
	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}		
	}

}
