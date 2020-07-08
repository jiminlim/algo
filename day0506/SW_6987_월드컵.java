package com.corona.day0506;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW_6987_월드컵 {

	static int[][] score;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0506/월드컵"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 4	; tc++) {
			System.out.println("________ "+tc);
			StringTokenizer st = new StringTokenizer(br.readLine());
			score = new int[6][3];
			for (int i = 0; i < score.length; i++) {
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
				score[i][2] = Integer.parseInt(st.nextToken());
			}
			HashMap<String, String> map = new HashMap<>();

			for (int i = 0; i < score.length; i++) {
				String key = "" + score[i][0] + score[i][1] + score[i][2];
				String value = "" + score[i][2] + score[i][1] + score[i][0];
				if (map.containsValue(key)) {
					map.remove(value);
				} else {
					map.put(key, value);
				}
				for(String k : map.keySet()) {
					System.out.println( k +"  value : " + map.get(k));
				}
				System.out.println();
			}
			
			if(map.isEmpty()) {
				System.out.print(1+" ");
			}else {
				System.out.print(0+" ");
			}
//
//			for (int i = 0; i < score.length; i++) {
//				System.out.println(score[i][0] +" "+score[i][1] +" "+score[i][2]);
//			}
//			System.out.println();

		}
	}
}
