package com.corona.day0418;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1786_찾기 {
	static String origin, pattern;
	static int[] getPI(String p) {
		int[] pi = new int[p.length()];
		int j = 0;
		for (int i = 1; i < p.length(); i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j))
				j = pi[j - 1];

			if (p.charAt(i) == p.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}

	static String kmp(String o, String p) {
		int[] pi = getPI(p);
		int cnt =0;
		int j = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < o.length(); i++) {
			while (j > 0 && o.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}

			if (j == p.length() - 1) {
				j = pi[j];
				cnt++; 
				sb.append(trim(i)+" ");
			} else {
				j++;
			}
		}
		String re = cnt+" "+sb.toString();
		return re;
	}

	private static String trim(int i) {
		String ori = origin.substring(0, i+1);
		System.out.println(ori.charAt(i)+" "+i);
		String t =ori.replace(" ","");
		int loc = i -(ori.length()-t.length())-pattern.length()+2;
		return loc+"";
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0418/찾기"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine();
		pattern = br.readLine();
		System.out.println(origin +" :::: "+pattern);
		
		String result = kmp(origin, pattern);
		StringTokenizer tk = new StringTokenizer(result);
		System.out.println(tk.nextToken());
		while(tk.hasMoreTokens()) {
			System.out.print(tk.nextToken()+" ");
		}
	}

}
