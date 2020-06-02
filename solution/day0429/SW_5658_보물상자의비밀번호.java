package com.corona.day0429;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class SW_5658_보물상자의비밀번호 {
	static int TC, N, K, M;
	static char[] six = { 'A', 'B', 'C', 'D', 'E', 'F' };
	static HashMap<Integer,String> map;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0429/보물상자의비밀번호"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());
			String str = br.readLine();
			M = N / 4;
			map = new HashMap<>();
			list = new ArrayList<>();
			for (int t = 0; t < M; t++) // 4번 회전
			{
				for (int k = 0; k < 4; k++) {
					getTen(str, k, t);
				}
				char cstr = str.charAt(N - 1);
				str = cstr + str.substring(0, N - 1);
			}
			Collections.sort(list);
			System.out.println("#"+tc+" "+list.get(list.size()-K));
		}
	}


	private static void getTen(String str, int k, int t) {
		int kk = k * M;
		int sum = 0;
		int po = M-1;
		String value = "";
		for (int i = kk; i < kk + M; i++) {
			char c = str.charAt(i);
			value += c;
			for (int d = 0; d < six.length; d++) {
				if (six[d] == c) {
					c = (char) ((d + 10) + '0');
					break;
				}
			}
			sum += (c - '0') * (Math.pow(16, po));
			po--;
		}
		if(!map.containsKey(sum)) {
			list.add(sum);
		}
		map.put(sum, value);
	}

}
