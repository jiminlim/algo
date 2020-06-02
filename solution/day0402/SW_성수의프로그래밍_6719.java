package com.corona.day0402;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SW_성수의프로그래밍_6719 {
	static int T, N, K;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/com/corona/day0402/성수프로그래밍"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());
			tk = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(tk.nextToken()));
			}
			Collections.sort(list);
			double score = 0.0;
			for (int i = list.size() - K; i < list.size() ; i++) {
				score = (score + list.get(i)) / 2;
			}
			
			System.out.println("#" + t + " " + (String.format("%.6f", score)));
		}

	}

}
