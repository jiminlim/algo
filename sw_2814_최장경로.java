package day0215;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GOPPaAeMDFAXB&categoryId=AV7GOPPaAeMDFAXB&categoryType=CODE&problemTitle=2814&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

public class sw_2814_최장경로 {
	static int tc, N,M,max;
	static boolean isv[];
	static int input[][]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			input = new int[N+1][N+1];
			isv = new boolean[N+1];
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				input[a][b] = 1;
				input[b][a] = 1;
			}
			
			max = 0;
			for (int i = 1; i <= N; i++) {
				isv[i] = true;
				dfs(i,1);
				isv[i] =false;
			}
			
			
			System.out.println("#"+t+" "+max);
		}
	}
	private static void dfs(int s, int cnt) {
		max = Math.max(max, cnt);
		for (int i = 1; i <= N; i++) {
			if(input[s][i]==1 && !isv[i] ) {
				isv[i] = true;
				dfs(i,cnt+1);
				isv [i] = false;
			}
		}
		
	}

}
