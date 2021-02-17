package day0217;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GOPPaAeMDFAXB&categoryId=AV7GOPPaAeMDFAXB&categoryType=CODE&problemTitle=2814&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

public class sw_2814_최장경로_저장 {
	static int tc, N,M,max;
	static int input[][],save[][]; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			input = new int[N+1][N+1];
			save = new int[1<< (N+1)][N+1]; // 1. 비트마스킹, 2. 정점
			// 101 일 때 3을 들린 값
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				input[a][b] = 1;
				input[b][a] = 1;
			}
			
			max = 0;
			for (int i = 1; i <= N; i++) {
				max = Math.max(max, dfs(i,1<<i));
			}
			
			
			System.out.println("#"+t+" "+max);
		}
	}
	private static int dfs(int v, int visit) {
		if(save[visit][v] != 0) { // 이미 한번 들려서 값이 저장됨. 
			return save[visit][v]; 
		}
		int res=1;
		for (int i = 1; i <= N; i++) {
			if(input[v][i]==1 && (visit &(1<<i))==0) {
				res = Math.max(res, dfs(i, visit | (1<<i))+1);
			}
		}
		save[visit][v]=res;
		return res;
		
	}

}
