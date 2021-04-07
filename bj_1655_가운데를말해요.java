package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1655_가운데를말해요 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((o1,o2)->o2-o1); //내림차순
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();//오름차순
		StringBuffer sb =new StringBuffer();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			//반으로나눠
			if(maxheap.size() == minheap.size()) maxheap.offer(input);
			else minheap.offer(input);
			
			//비교해
			if(!maxheap.isEmpty() && !minheap.isEmpty()) {
				if(minheap.peek() < maxheap.peek()) {
					int tmp = minheap.poll();
					minheap.offer(maxheap.poll());
					maxheap.offer(tmp);
				}
			}
			
			sb.append(maxheap.peek()+"\n");
		}
		System.out.println(sb.toString());
	}

}
