package day0222;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sw_4534_트리흑백색칠 {
	static final int MOD = 1000000007;
    static int N; // 정점의 수
    static List[] adj; // 정점 리스트
    static long[][] memo; //색상, 정점 번호 -> 저장
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in	);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			adj = new ArrayList[N+1];
			for (int i = 1; i < N+1; i++) {
				adj[i]= new ArrayList<>();
			}
			memo = new long[2][N+1];
			
			for (int i = 1; i < N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			
			//1 = 시작 노드 , 컬러, 부모(-1= 부모없음.)
			long ans = (dfs(1,0,-1) + dfs(1,1,-1)) % MOD;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static long dfs(int v, int color, int parent) {
		if(memo[color][v] != 0) return memo[color][v];
		
		long res =1;
		
		//color가 흑(0)인 경우.
        //자식 노드들을 백(1)으로 칠한 경우의 경우의수들의 곱
		if(color == 0) {
			for (int i = 0; i < adj[v].size(); i++) {
				if((int)adj[v].get(i)!=parent) {
					res *= dfs((int) adj[v].get(i), 1, v);
					res %= MOD;
				}
			}
		}
		else{ 
			for (int i = 0; i < adj[v].size(); i++) {
				if((int)adj[v].get(i)!=parent) {
					res *= (dfs((int) adj[v].get(i), 1, v)+
							dfs((int) adj[v].get(i), 0, v));
					res %= MOD;
				}
			}
		}
		
		memo[color][v] = res;
		return res;
	}
	
	

}
