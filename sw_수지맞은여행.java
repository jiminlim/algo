package day0221;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_수지맞은여행 {
	static int[][] input, dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[] alpha;
	static int max,R,C;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0221/수지"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			R = Integer.parseInt(tk.nextToken());
			C = Integer.parseInt(tk.nextToken());
			
			max = 0;
			input = new int[R][C];
			alpha = new boolean[26];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					input[i][j] = str.charAt(j)-'A';
				}
			}
			
			alpha[input[0][0]] = true;
			dfs(0,0,1);
			
			System.out.println("#"+tc+" "+max);
		}
		
	}
	private static void dfs(int y, int x, int cnt) {
		max = Math.max(max, cnt);
		
		for (int i = 0; i < 4; i++) {
			int ny= y+ dir[i][0];
			int nx = x+dir[i][1];
			
			if(check(ny,nx) && !alpha[input[ny][nx]]) {
				alpha[input[ny][nx]]= true;
				dfs(ny,nx,cnt+1);
				alpha[input[ny][nx]]= false;
			}
		}
		
	}
	private static boolean check(int ny, int nx) {
		if(ny >= 0 && ny< R && nx >=0 && nx <C) return true;
		return false;
	}

}
