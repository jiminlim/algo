package day0408;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15684_��ٸ����� {
	static int N,H,M,map[][];
	static boolean flag;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("./src/day0408/��ٸ�"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
		}
		flag = false;
		int i =0;
		for (i = 0; i <= 3; i++) {
			dfs(1,0,i);
			if(flag) break;
		}
		System.out.println(flag? i:-1);
	}
	private static void dfs(int x, int cnt, int ladder_num) {
		if(flag) return;
		if(cnt == ladder_num) {
			//üũ 
			if(check()) {
				flag = true;
			}
			return;
		}
		for (int h = x; h < H+1; h++) {
			for (int n = 1; n < N; n++) {
				//��ٸ� ���� üũ
				if(map[h][n-1]==1 || map[h][n]==1 ||map[h][n+1]==1) continue;
				map[h][n]=1;
				dfs(h,cnt+1,ladder_num);
				map[h][n]=0;
			}
		}
		
		
	}
	private static boolean check() {
		//i��°�� i��° �����ϴ��� 
		for (int i = 1; i < N+1; i++) {
			int h = 1;
			int n = i;
			while(h<H+1) {
				if(map[h][n]==1) {
					n++;
				}else if(map[h][n-1]==1) {
					n--;
				}
				h++;
			}
			if(n!=i) return false;
		}		
		return true;
	}

}
