package com.corona.day0418;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BJ_2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0418/계단오르기"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		int[] stair = new int[s+1];
		for (int i = 0; i < s; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		int[][] jump = new int[s+1][2];
		jump[0][1] = stair[0];
		jump[1][0] = jump[0][1]+stair[1];
		jump[1][1] = stair[1];
		for (int i = 2; i < s; i++) {
			jump[i][0]=jump[i-1][1]+stair[i];
			jump[i][1]=Math.max(jump[i-2][0], jump[i-2][1])+stair[i];
		}
		
		System.out.println(Math.max(jump[s-1][0], jump[s-1][1]));
	}

}
