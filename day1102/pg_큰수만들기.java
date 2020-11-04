package day1102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class pg_큰수만들기 {

	public static void main(String[] args) {
		int k = 3;
		String number = "1924";
		solution(number, k);
	}

	public static String solution(String number, int k) {
		int N = number.length()-k;
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = number.length()-N;
		int max = -1;
		int lo =0 ;
		while (N >0) {
			max =-1;
			for (int j = start; j <= end; ++j) {
				int num = number.charAt(j)-'0';
				if (max < num) {
					max = num;
					lo = j;
				}
			}
			sb.append(number.charAt(lo));
			start = lo+1;
			end = number.length() - --N;
		}
		return sb.toString();
	}

}
