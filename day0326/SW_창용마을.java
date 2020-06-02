package com.corona.day0326;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class SW_창용마을 {
	static int T, N, M;
	static int[][] p;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("창용마을"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			p = new int[N+1][N+1];
			v = new boolean[N+1];
			//p에 둘다 1을 넣어줌 
			for (int i = 0; i < M; i++) {
				tk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				p[a][b] =1; p[b][a]=1;
			}
			
			//i=1~N 까지 돌리면서 
			int cnt=0;
			for (int i = 1; i < N+1; i++) {
				// if v= false -> dfs (i)
				if (!v[i]) {
					dfs(i);
					cnt++;
				}
			}
			System.out.println("#"+t+" "+ cnt);
		}
	}
	private static void dfs(int i) {
		v[i]=true;
		for (int j = 1; j < N+1; j++) {
			if (!v[j] && p[i][j]==1) {
				dfs(j);
			}
		}
	}
/* 유니온 알고리즘 
	 static int N,M;
	    static int[] ver;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T=sc.nextInt();
	        for(int t=1;t<=T;t++){
	            N=sc.nextInt();
	            M=sc.nextInt();
	            ver = new int[N];
	            for(int i=0;i<N;i++)
	                ver[i]=i;
	            for(int i=0;i<M;i++){
	                int a=sc.nextInt()-1;
	                int b=sc.nextInt()-1;
	                int v1 = ver[a];
	                int v2 = ver[b];
	                if(v1!=v2){
	                    for(int j=0;j<N;j++){
	                        if(ver[j]==v2){
	                            ver[j]=v1;
	                        }
	                    }
	                }
	            }
	            Set<Integer> set = new HashSet<>();
	            for(int i=0;i<N;i++){
	                set.add(ver[i]);
	            }
	            System.out.println("#"+t+" "+set.size());
	        }
	    }
*/	    
}
