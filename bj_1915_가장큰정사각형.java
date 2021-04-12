package day0412;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1915_가장큰정사각형 {
	static int map[][], N,M,max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		map = new int[N][M];
		
		max = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(map[i][j]==1) max =1;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if(map[i][j] == 0) continue;
				int a = Math.min(map[i][j-1], map[i-1][j]);
				map[i][j] = Math.min(a, map[i-1][j-1])+1;
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max*max);
		
		
	}
}
