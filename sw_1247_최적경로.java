package day0204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sw_1247_최적경로 {
	static int TC, N, Sy, Sx, Ey,Ex, min;
	static int[][] customers;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0204/최적경로"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
			Sx = Integer.parseInt(tk.nextToken());
			Sy = Integer.parseInt(tk.nextToken());
			Ex = Integer.parseInt(tk.nextToken());
			Ey = Integer.parseInt(tk.nextToken());
			min = Integer.MAX_VALUE; 
			
			customers = new int[N][2];
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(tk.nextToken());
				customers[i][1] = Integer.parseInt(tk.nextToken());
			}
			
			permu(0,0,Sx,Sy,0); // 재귀적 순열, 비트마스킹
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void permu(int count, int visited, int sx, int sy, int sum) {
		if(sum >= min) return;
		if(count == N) {
			sum+= Math.abs(sx - Ex)+ Math.abs(sy-Ey); // 마지막 고객과 집사이의 거리.
			if(min > sum){
				min = sum;
			}
			return;
		}
		
		//순열
		for (int i = 0; i < N; i++) {
			if((visited & 1 << i) == 0) { // 지나가지 않음.
				permu(count+1, visited | (1<<i),customers[i][0],customers[i][1], 
						sum + Math.abs(sx - customers[i][0])+ Math.abs(sy-customers[i][1]));
			}
		}
		
	}

}
