package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1655_��������ؿ� {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((o1,o2)->o2-o1); //��������
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();//��������
		StringBuffer sb =new StringBuffer();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			//�����γ���
			if(maxheap.size() == minheap.size()) maxheap.offer(input);
			else minheap.offer(input);
			
			//����
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
