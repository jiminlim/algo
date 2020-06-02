package com.corona.day0325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5 17 
public class BJ_숨바꼭질 {
	static int S, E;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("숨바꼭질"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		S = Integer.parseInt(tk.nextToken());
		E = Integer.parseInt(tk.nextToken());
		visited = new int[100001];

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(S);
		visited[S] = 1;

		while (!que.isEmpty()) {
			int n = que.poll();
			if (n == E) {
				break;
			}
			if (n * 2 <= 100000 && visited[n * 2] == 0) {
				que.add(n * 2);
				visited[n * 2] = visited[n] + 1;
			}
			if (n + 1 <= 100000 && visited[n + 1] == 0) {
				que.add(n + 1);
				visited[n + 1] = visited[n] + 1;
			}
			if (n - 1 >= 0 && visited[n - 1] == 0) {
				que.add(n - 1);
				visited[n - 1] = visited[n] + 1;
			}
		}

		
		System.out.println(visited[E]-1);
	}

}
