package day0222;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sw_4534_Ʈ������ĥ {
	static final int MOD = 1000000007;
    static int N; // ������ ��
    static List[] adj; // ���� ����Ʈ
    static long[][] memo; //����, ���� ��ȣ -> ����
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
			
			//1 = ���� ��� , �÷�, �θ�(-1= �θ����.)
			long ans = (dfs(1,0,-1) + dfs(1,1,-1)) % MOD;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static long dfs(int v, int color, int parent) {
		if(memo[color][v] != 0) return memo[color][v];
		
		long res =1;
		
		//color�� ��(0)�� ���.
        //�ڽ� ������ ��(1)���� ĥ�� ����� ����Ǽ����� ��
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
