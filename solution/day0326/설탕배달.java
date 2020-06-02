package com.corona.day0326;

import java.util.Scanner;

/*
 18 
 4
 6
 9
 11
 */
public class 설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		int ans = 0;
		while (num % 5 != 0 && num >= 0) {
			num -=3;
			cnt++;
		}
		
		ans = num <0? -1 : cnt+num/5;
		System.out.println(ans);
	}

}

