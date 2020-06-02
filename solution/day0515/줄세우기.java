package com.corona.day0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_교수 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        br = new BufferedReader(new StringReader(src));
	        StringTokenizer tokens = new StringTokenizer(br.readLine());
	        int V = Integer.parseInt(tokens.nextToken());
	        int E = Integer.parseInt(tokens.nextToken());
	        List<Integer>[] graph = new List[V + 1];
	        for (int i = 0; i < graph.length; i++) {
	            graph[i] = new ArrayList<Integer>();
	        }
	        int[] indegrees = new int[V + 1];
	        for (int i = 0; i < E; i++) {
	            tokens = new StringTokenizer(br.readLine());
	            int from = Integer.parseInt(tokens.nextToken());
	            int to = Integer.parseInt(tokens.nextToken());
	            graph[from].add(to);
	            indegrees[to]++;
	        }
	        // System.out.println(Arrays.toString(indegrees));
	        Queue<Integer> q = new LinkedList<>();
	        for (int i = 1; i < indegrees.length; i++) {
	            if (indegrees[i] == 0) {
	                q.offer(i);
	            }
	        }
	        // System.out.println(q);
	        StringBuilder sb = new StringBuilder();
	        while (!q.isEmpty()) {
	            int front = q.poll();
	            sb.append(front).append(" ");
	            List<Integer> childs = graph[front];
	            for (int child : childs) {
	                indegrees[child]--;
	                if (indegrees[child] == 0) {
	                    q.offer(child);
	                }
	            }
	        }
	        System.out.println(sb);
	    }

	    private static String src = "4 2\r\n" +
	                                "4 2\r\n" +
	                                "3 1";
}
