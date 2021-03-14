package day0314;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class sw_ÇÜ½ºÅÍ6 {
	static int N, X, M, max;
	static int[][] record;
	static String str ;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0314/ÇÜÂî"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			M = sc.nextInt();
			max = -1;
			record = new int[M][3];
			for (int i = 0; i < M; i++) {
				record[i][0] = sc.nextInt();
				record[i][1] = sc.nextInt();
				record[i][2] = sc.nextInt();
			}
			int[] arr = new int[N+1];
			permu(arr,0,0);
			
			System.out.println("#"+tc+" "+(max==-1?max:str));
		}
	}

	private static void permu(int[] arr, int idx, int sum) {
		if(idx == arr.length) {
			if(check(arr)) {
				if(sum > max) {
					max = sum;
					saveARR(arr);
				}
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			arr[idx] = i;
			permu(arr,idx+1, sum+i);
		}
	}

	private static void saveARR(int[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < arr.length; i++) {
			sb.append(arr[i]+" ");
		}
		str = sb.toString();
	}

	private static boolean check(int[] arr) {
		for (int i = 0; i < M; i++) {
			int l = record[i][0];
			int r = record[i][1];
			int s = record[i][2];
			int sum =0;
			for (int j = l; j <= r ; j++) {
				sum+= arr[j];
			}
			if(sum != s) {
				return false;
			}
		}
		return true;
	}

}
