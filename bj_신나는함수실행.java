package day0415;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는함수실행 {
	static int[][][] w;
	static int a,b,c;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0415/신나는"));
		w =new int[21][21][21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (stop(br.readLine())) {
			int result = dp(a,b,c);
			System.out.println("w("+a+", "+b+", "+c+") = "+result);
		}
		
	}
	private static int dp(int a, int b, int c) {
		if(a<=0 || b<=0|| c<= 0) return 1;
		if(a> 20 || b>20 || c>20) {
			return dp(20,20,20);
		}
		if(w[a][b][c]!=0) return w[a][b][c];
		if(a<b && b<c) {
			w[a][b][c] =dp(a,b,c-1)+dp(a,b-1,c-1)-dp(a,b-1,c);
			return w[a][b][c];
		}
		w[a][b][c] =dp(a-1,b,c)+dp(a-1,b-1,c)+dp(a-1,b,c-1)-dp(a-1,b-1,c-1);
		return w[a][b][c];
	}
	private static boolean stop(String read) {
		if(read.equals("-1 -1 -1"))
			return false;
		StringTokenizer tk = new StringTokenizer(read);
		a= Integer.parseInt(tk.nextToken());
		b= Integer.parseInt(tk.nextToken());
		c= Integer.parseInt(tk.nextToken());
		return true;
	}

}
