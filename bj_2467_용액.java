package day0409;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2467_용액 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("./src/day0409/용액"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(tk.nextToken());
		}

		int plus = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				plus = i;
				break;
			}
		}
		int i =0, j = arr.length-1;
		long min = Long.MAX_VALUE;
		long a =0, b = 0;
		while(i<j) {
			long sum = arr[i]+arr[j];
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = arr[i];
				b = arr[j];
			}
			
			if(sum <0) {
				i++;
			}else {
				j--;
			}
		}
		System.out.println(a+" "+b);
		
	}

}
