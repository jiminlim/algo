package day1205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_bfs_dfs1260 {
	static boolean[] visit;
	static LinkedList<Integer> list[] ;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day1205/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int start = Integer.parseInt(tk.nextToken());
		
		
		list = new LinkedList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(tk.nextToken());
			int p2 = Integer.parseInt(tk.nextToken());
			list[p1].add(p2);
			list[p2].add(p1);
		}
		
		StringBuilder st = new StringBuilder();
		visit = new boolean[N+1];
		dfs(visit,start,st);
		System.out.println(st);
		st = new StringBuilder();
		visit = new boolean[N+1];
		bfs(visit,start,st);
		System.out.println(st);
		
	}
	private static void bfs(boolean[] visit, int node, StringBuilder st) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(node);
		
		while(!que.isEmpty()) {
			node = que.poll();
			if(visit[node])continue;
			visit[node] = true;
			st.append(node+" ");
			for (int next : list[node]) {
				que.offer(next);
			}
		}
		
	}
	private static void dfs(boolean[] visit, int node, StringBuilder st) {
		if(visit[node]) return;
		visit[node]=true;
		st.append(node+" ");
		for (int next : list[node]) {
			dfs(visit,next,st);
		}
	}

}
