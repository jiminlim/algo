package com.corona.day0602;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_스타트와링크_14889 {
		static int N, M, min, Sum;
		static int[][] score;
		static int[] start, link, a;
		public static void main(String[] args) throws Exception {
			System.setIn(new FileInputStream("./src/com/corona/day0602/스타트"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			M = N / 2;
			min = Integer.MAX_VALUE;
			score = new int[N][N];
			start = new int[N/2];  link = new int[N/2];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 완료

			//임시팀 배열
			a = new int[2];
			// 조합1 - 팀나누기 
			divideTeam(0,0);
			
			System.out.println(min);
			
		}
		private static void divideTeam(int starti, int cnt) {
			if(cnt==M) {
				//나뉜 팀. start/ link팀 구하기
				findLink();

				Sum=0;
				TeamScore(0,0,start);
				int startSum = Sum; 
				Sum=0;
				TeamScore(0,0,link);
				int linkSum = Sum;
				
				min = Integer.min(min, Math.abs(startSum-linkSum));
				
				if(min==0) {
					System.out.println(min);
					System.exit(0);
				}
				return;
			}
			
			for (int i = starti; i < N; i++) {
				start[cnt]=i;
				divideTeam(i+1,cnt+1);
			}
		}
		private static void TeamScore(int starti, int cnt, int[] team) {
			if(cnt==2) {
				//나온 a배열의 S값 다 더해주기
				Sum+=(score[a[0]][a[1]]+score[a[1]][a[0]]);
				return;
			}
			for (int i = starti; i < M; i++) {
				a[cnt]=team[i];
				TeamScore(i+1, cnt+1, team);
			}
		}
		private static void findLink() {
			int scnt =0; int lcnt=0;
			for (int i = 0; i < N; i++) {
				if(scnt<M && i==start[scnt])	{
					scnt++;
				}else {
					link[lcnt]=i;
					lcnt++;
				}
			}
		}
}
