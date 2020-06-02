package com.corona.day0402;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1. Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다(여기서는 로얄 플러쉬를 포함한다. 로얄 플러쉬는 모두 동일한 슈트에 T, J, Q, K, A를 갖는다).
//2. Four of a Kind : 5장 중 4개의 랭크(값)가 모두 같다.
//3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
//4. Flush : 5장이 모두 동일한 슈트다.
//5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
//6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3).
//7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3).
//8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7).
//9. High card : 1~8번에 해당하지 않는다.  
//4개의 슈트(모양: S, D, H, C)와 13개의 랭크(값 : A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K)로 구성된 52장
public class SW_pokergame_9760 {
	static int T;
	static char[] sin;
	static int[] suit, rank, rin;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("포커게임"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sin = new char[6];// 받은값
			rin = new int[6];
			suit = new int[5]; // 받은 값의 갯수
			rank = new int[14];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 5; i++) {
				String card = tk.nextToken();
				sin[i] = card.charAt(0);
				inSuit(i);
				char r = card.charAt(1);
				if (r - '0' < 10) {
					rin[i] = r - '0';
					rank[rin[i]]++;
				} else {
					inRank(r, i);
				}
			}
			System.out.println(Arrays.toString(suit));
			System.out.println(Arrays.toString(rank));
			int s_max = sCount();
			int[] r_max = rCount();
			String result = null;
			boolean flag=false;
			if (s_max == 5) {
				if (r_max[0] == 5) { 
					result ="Straight Flush";
					flag = true;
				} else { 
					result ="Flush";
					flag = true;
				}
			}
			if (!flag && r_max[0] == 5) {
				result = "Straight";
				flag = true;
			} 
			if (!flag && r_max[0] == 4) {
				result = "Four of a Kind";
				flag = true;
			} 
			if (!flag && r_max[0] == 3) {
				if (r_max[1] == 1) {
					result = "Full House";
					flag = true;
				} else {
					result = "Three of a kind";
					flag = true;
				}
			}
			if (!flag && r_max[0] == 2) {
				if (r_max[1] == 2) {
					result = "Two pair";
					flag = true;
				} else {
					result = "One pair";
					flag = true;
				}
			}
			if (!flag) {
				result = "High card";
			}

			System.out.println("#"+t+" "+result);
		}
	}

	private static int[] rCount() {
		int r_max[] = new int[2];
		int check = 0;
		for (int i = 1; i < 14; i++) {
			if(rank[i] == 2) r_max[1]++;
			if (rank[i] > r_max[0]) {
				r_max[0] = rank[i];
				check = i;
			}
		}
		if (r_max[0] == 1 && check < 10) {
			int cnt=0;
			for (int i = check; i <check+5; i++) {
				if(rank[i]==1) cnt++;
			}
			if(cnt==5)r_max[0] = 5;
		}
		return r_max;
	}

	private static int sCount() {
		int s_max = 0;
		for (int i = 1; i < 5; i++) {
			if (suit[i] > s_max) {
				s_max = suit[i];
			}
		}
		return s_max;
	}

	private static void inRank(char r, int i) {
		switch (r) {
		case 'A':
			rin[i] = 1;
			rank[rin[i]]++;
			break;
		case 'T':
			rin[i] = 10;
			rank[rin[i]]++;
			break;
		case 'J':
			rin[i] = 11;
			rank[rin[i]]++;
			break;
		case 'Q':
			rin[i] = 12;
			rank[rin[i]]++;
			break;
		case 'K':
			rin[i] = 13;
			rank[rin[i]]++;
			break;
		}
	}

	private static void inSuit(int j) {
		switch (sin[j]) {
		case 'S':
			suit[1]++;
			break;
		case 'D':
			suit[2]++;
			break;
		case 'H':
			suit[3]++;
			break;
		case 'C':
			suit[4]++;
			break;
		}
	}

}
