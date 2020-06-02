package com.corona.day0417;

import java.util.Arrays;

public class dp_동전 {
	//동전 8원일때 거스름돈을 구하라 (1,4,6원짜리를 최소한의 갯수로)
	public static void main(String[] args) {
		//1차원 배열에 업데이트 해서 동전 거스름돈 개수를 저장해봦
		int n = 10;
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = i; //1월짜리 필요한 개수
		}
		System.out.println(Arrays.toString(c));
		//1,4원 동전 모두 고려
		for (int i = 4; i < c.length; i++) {
//			c[i] = 1원짜리 동전만 고려한 최소개수
//			c[i-4]+1 : 1원, 4원 짜리 동전 고려한 최소 개수
			if(c[i]>c[i-4]+1)
				c[i]=c[i-4]+1;
		}
		System.out.println(Arrays.toString(c));
		
		//1,4,6원 동전 모두 고려
		for (int i = 6; i < c.length; i++) {
//			c[i] = 1,4원짜리 동전만 고려한 최소개수
//			c[i-6]+1 : 1원, 4원 ,6원 짜리 동전 고려한 최소 개수
			if(c[i]>c[i-6]+1)
				c[i]=c[i-6]+1;
		}
		System.out.println(Arrays.toString(c));
		
		System.out.println(c[8]);
		
	}

}
