package com.corona.day0227;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌꿀채취_온라인 {

	static int N, M, C;
	static int[][] map, maxMap; // maxMap : 최대이익

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("벌꿀체취"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
				// 1. 각 ij 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			// 2. 두 일꾼의 조합
			System.out.println("#"+t+" "+getMaxBenefit());

		}
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
				
			}
		}
	}

	// i :행위치, j : 열위치, cnt: 고려한 원소 수 (부분집합을) , sum : 부분집합에 속한 원소의 합, powSum : 부분집합에
	// 속한 원소의 이익
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if(sum>C) return; //부분 집합의 합이 목표량 c를 초과하면 리턴
		if (cnt == M) {
			//0,0 M=2
			//0,0 0,1 0,2-여기에서  2-2이므로 ij 위치 알수있다!
			if (maxMap[i][j-M]<powSum) {
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		// i,j 위치 원소 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j]*map[i][j]);
		// i,j 위치 원소 비선택
		makeMaxSubset(i, j+1, cnt+1, sum, powSum);

	}
	
	private static int getMaxBenefit() { //가장 큰값 리턴
		int max =0, temp =0; //max 조합적선택후의 최대이익 값
		//1.일꾼A 기준 선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) { //a일꾼 조합 기준
				//2. b일꾼 선택
				//같은 행기준 선택
				for (int t = j+M; t <= N-M; t++) {
					temp = maxMap[i][j]+maxMap[i][t];
					if (max < temp) {
						max = temp;
					}
				}
				
				//다음행부터 마지막행까지 선택
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <=N-M; j2++) {
						temp = maxMap[i][j]+maxMap[i2][j2];
						if (max < temp ) {
							max = temp;
						}
					}
				}
				
			}
		}
		return max;
	}
}
