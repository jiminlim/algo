package com.corona.day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_거스름돈 {
	static int m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		m=380;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		m =Integer.parseInt(br.readLine());
//		
		int cnt =0;
		int n = 1000-m;
		if (n>=500) {
			n=n-500;
			cnt++;
		}
		while (n>=100) {
			n=n-100;
			cnt++;
		}
		if(n>=50) {
			n=n-50; cnt++;
		}
		while(n>=10) {
			n=n-10;
			cnt++;
		}
		if (n>=5) {
			n=n-5; cnt++;
		}
		while(n>=1) {
			n=n-1; cnt++;
		}
		System.out.println(cnt);
	}

}
