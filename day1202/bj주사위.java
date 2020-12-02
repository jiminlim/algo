package day1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj주사위 {
	static int N,M, K,x,y;
	static int[][] dir={{0,1},{0,-1},{-1,0},{1,0}}, map,dice;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day1202/주사위"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		x = Integer.parseInt(tk.nextToken());
		y = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		
		map  = new int[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		dice = new int[4][3];
		tk = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int d= Integer.parseInt(tk.nextToken())-1;
			int nx = x+dir[d][0];
			int ny = y+dir[d][1];
			
			if(check(nx,ny)) {
				//주사위 굴러감.
				diceRun(d);
				//주사위 바닥과 맵 비교  
				if(map[nx][ny]==0) { //주사위 -> 칸
					map[nx][ny] = dice[3][1];
				}else { //칸 -> 주사위
					dice[3][1] = map[nx][ny];
					map[nx][ny] = 0;
				}
				
				//주사위 윗면 출력
				System.out.println(dice[1][1]);
				//범위 안이면 
				x = nx;
				y = ny;
			}
			
		}	
		
		
	}
	private static void diceRun(int d) {
		int tmp1 =0, tmp2=0;
		switch (d) {
		case 0: //동
			tmp1 = dice[1][1];
			dice[1][1] = dice[1][0];
			tmp2 = dice[1][2];
			dice[1][2] = tmp1;
			tmp1 = tmp2;
			tmp2 = dice[3][1];
			dice[3][1] = tmp1;
			dice[1][0] = tmp2;
			break;
		case 1: //서
			tmp1 = dice[1][1];
			dice[1][1] = dice[1][2];
			tmp2 = dice[1][0];
			dice[1][0] = tmp1;
			tmp1 = tmp2;
			tmp2 = dice[3][1];
			dice[3][1] = tmp1;
			dice[1][2] = tmp2;
			break;
		case 2: // 북
			tmp1 = dice[1][1];
			dice[1][1] = dice[2][1];
			tmp2 = dice[0][1];
			dice[0][1] = tmp1;
			tmp1 = tmp2;
			tmp2 = dice[3][1];
			dice[3][1] = tmp1;
			dice[2][1] = tmp2;
			break;
		case 3: //남
			tmp1 = dice[1][1];
			dice[1][1] = dice[0][1];
			tmp2 = dice[2][1];
			dice[2][1] = tmp1;
			tmp1 = tmp2;
			tmp2 = dice[3][1];
			dice[3][1] = tmp1;
			dice[0][1] = tmp2;
			break;
		}
	}

	private static boolean check(int ny, int nx) {
		if(ny>=0 && nx>=0 && ny<N&& nx<M) return true;
		return false;
	}

}
