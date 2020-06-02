package com.corona.day0501;

import java.io.FileInputStream;
import java.util.Scanner;

public class SW_4366_정식은행업무 {
	static int T;
	static String n2, n3;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0501/은행업무"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n2 = sc.next();
			n3 = sc.next();
			long data2 = 0;
			for (int i = n2.length() - 1; i >= 0; i--) {
				data2 = change2(i);
				System.out.println("2진수 "+data2);
				// 10진수를 3진수로 변경
				int flag = change3(data2);
				if (flag == 1) {
					break;
				}
			}

			System.out.println("#"+t+" "+data2);
		}
	}

	private static int change3(long data2) {
		String a = "";
		while (data2 > 3) {
			a = data2 % 3 + a;
			data2 = data2 / 3;
		}
		a = data2 + a;
		int flag = 0;
		String n = n3;
		if(a.length()!=n3.length()) {
			if(a.length()==n3.length()-1) 
				a= "4"+a;
			else if(a.length()==n3.length()+1)
				n="4"+n;
		}
		for (int i = 0; i < n.length(); i++) {
			if (a.charAt(i) != n.charAt(i)) {
				flag++;
				if (flag > 1)
					break;
			}
		}
		return flag;
	}

	private static int change2(int i) {
		char num = n2.charAt(i);
		if (num == '0') {
			num = '1';
		} else {
			num = '0';
		}
		String data1 = n2.substring(0, i);
		String data2 = n2.substring(i + 1, n2.length());
		String result = data1 + num + data2;
		System.out.println(result );
		// 2진수->10진수로
		int po = 0, sum = 0;
		for (int j = n2.length() - 1; j >= 0; j--) {
			int a = result.charAt(j) - '0';
			sum += a * Math.pow(2, po);
			po++;
		}
		return sum;
	}

}
