package day0114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1476_날짜계산 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day0114/날짜"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(tk.nextToken());
		int S = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());

		int e = 0;
		int year = 0;
		
//		if(E==15) E =0;
		if(S==28) S =0;
		if(M==19) M =0;
		boolean flag = true;
		while (flag) {
			year = 15 * e + E;
			if (year%28==S) {
				if(year%19==M) {
//					System.out.println("e"+e);
					flag = false;
				}
			}
			e++;
		}
		
		System.out.println(year);

	}

}
