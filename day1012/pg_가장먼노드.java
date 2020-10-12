package day1012;

import java.util.LinkedList;
import java.util.Queue;

public class pg_가장먼노드 {

	public static void main(String[] args) {
		int n = 7;
		int[][] edge = {{1,5},{1,3},{1,4},{4,6},{2,7},{2,3},{5,3}};
//		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(n, edge));
	}
	
	 public static int solution(int n, int[][] edge) {
	        int answer = 0;
	        Queue<Integer> que = new LinkedList<Integer>();
	        boolean[][] data = new boolean[n+1][n+1];
	        boolean[] visit = new boolean[n+1];
	        
	        //2차원에 넣어줌.
	        for (int i = 0; i < edge.length ; i++) {
				data[edge[i][0]][edge[i][1]]=true;
				data[edge[i][1]][edge[i][0]]=true;
			}
	        
	        visit[1] = true;
	        que.offer(1);
	        int size =que.size();
	        
	        // bfs
	        while(!que.isEmpty()) {
	        	size =que.size();
//	        	System.out.println(que.size());
	        	for (int i = 0; i < size; i++) {
	        		int node = que.poll();
//	        		System.out.println("node " +node);
	        		for (int j = 1; j < n+1; j++) {
						if(data[node][j] && !visit[j]) {
//							System.out.println("que add "+j);
							que.offer(j);
							visit[j]=true;
						}
					}
				}
	        	
	        	if(que.isEmpty()) {
	        		answer = size;
	        	}
	        }
//	        System.out.println("--------------------");
	        return answer;
	    }

}
