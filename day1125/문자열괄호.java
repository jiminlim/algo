package day1125;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class ¹®ÀÚ¿­°ýÈ£ {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1125/°ýÈ£"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			Stack<Character> sk = new Stack<>();
			String input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					sk.push(input.charAt(i));
				} else if (sk.size()!=0 && sk.peek() == '(') {
					sk.pop();
				} else {
					sk.push(input.charAt(i));
					break;
				}
			}

			System.out.println(sk.size() == 0 ? "YES" : "NO");
		}

	}

}
