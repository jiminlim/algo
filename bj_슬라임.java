package day1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj_ΩΩ∂Û¿” {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (tk.hasMoreTokens()) {
			list.add(Integer.parseInt(tk.nextToken()));
		}
		
		Collections.sort(list, Comparator.reverseOrder());
		int num = list.get(0);
		int result =0;
		for (int i = 1; i < list.size(); i++) {
			int next =  list.get(i);
			result += num * next;
			num += next;
		}
		System.out.println(result);
		
	}

}
