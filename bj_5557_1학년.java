package day0329;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class bj_1학년 {
	static int N, nums[];
	static long cnt, memo[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0329/1학년"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(nums));
		int len = N-1;
		memo = new long[N][21];
		memo[0][nums[0]]=1;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 21; j++) {
				if(memo[i-1][j] != 0) {
					int plus = j+ nums[i];
					if(plus >= 0 && plus <= 20) {
						memo[i][plus] += memo[i-1][j];
					}
					int mi = j- nums[i];
					if(mi >= 0 && mi <= 20) {
						memo[i][mi] += memo[i-1][j];
					}
				}
			}
		}
		System.out.println(memo[len-1][nums[N-1]]);
		for (int i = 0; i < N; i++) {	
			System.out.println(Arrays.toString(memo[i]) );
		}
		
	}

}
