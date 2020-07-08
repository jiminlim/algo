package com.corona.day0412;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리_크루스칼 {
	static int V, E; // 정점, 간선 개수
	static int[][] table;
	static int[] parent, rank;

	static void makeSet(int x) {
		parent[x] = x;
	}

	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}
	
	static void union(int a,int b) {
		if(rank[a] > rank[b]) {
			parent[b] = a;
		}else {
			parent[a] = b;
			if(rank[a] == rank[b])
				rank[b]++;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/com/corona/day0412/최소스패닝크루스칼"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tk.nextToken());
		E = Integer.parseInt(tk.nextToken());
		table = new int[E][3];
		parent = new int[V+1];
		rank = new int[V+1];
		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(tk.nextToken());
			table[i][1] = Integer.parseInt(tk.nextToken());
			table[i][2] = Integer.parseInt(tk.nextToken());
		}
		// 입력 완료
		// 오름차순 정렬
		Arrays.sort(table, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		// makeSet
		for (int i = 0; i < V; i++)
			makeSet(i);

		int cnt =0, result =0;
		// for 1~E 까지 돌려서 메소드에 보내기
		for (int i = 0; i < E; i++) {
			// find()
			int a = find(table[i][0]);
			int b = find(table[i][1]);
			
			if(a==b) continue;
			// union()
			union(a,b);
			result += table[i][2];
			cnt++;
			if(cnt ==V-1) {
				break;
			}
		}
		System.out.println(result);
	}

}
