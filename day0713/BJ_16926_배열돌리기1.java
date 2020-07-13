package day0713;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1 {
	static int R,C,T;
	static int[][] map;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //우 하 좌 상
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0713/배열돌리기1"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		T = Integer.parseInt(tk.nextToken());
		
		map= new int[R][C];
		
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		int x = 0; int y = 0, first =0;
		for (int t = 0; t < T; t++) 
		{
			int rstart = 0, rend = R; int cstart = 0; int cend = C;
			//while 사이값이 없다면 false;
			while(play(rstart,rend,cstart,cend)) {
				first = map[y][x];
				boolean go = true;
				int n = 0,ny =0,nx=0;
				for (int i = 0; i < 4; i++) {
					go = true;
					while(go) {
						ny = y + dir[i][0]; nx = x +dir[i][1];
						if(!check(ny,nx,rstart,rend,cstart,cend)) {
							go = false;
						}else {
//							System.out.println(y+" "+x);
							map[y][x] = map[ny][nx];
							y=ny; x = nx;
						}
					}
				}
				map[y+1][x] = first;
				rstart++; rend--; cstart ++; cend--; // 하나씩 줄어든다. 
				y = rstart; x = cstart;
			}
			y=0;x=0;
		}
		print();
		
	}
	private static boolean play(int rstart, int rend, int cstart, int cend) {
		if(rstart==rend || cstart==cend)return false;
		return true;
	}
	private static boolean check(int ny, int nx, int rstart, int rend, int cstart, int cend) {
		if(ny>=rstart && nx>=cstart&& ny<rend && nx <cend) return true;
		return false;
	}
	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	
}
