package day0430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class pg_기능개발 {

	public static void main(String[] args) {
		int[] progresses= {99, 98, 97, 96, 80, 79};
		int[] speeds= {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int n = progresses.length;
		Queue<int[]> que = new LinkedList<int[]>();
		for (int j = 0; j < n; j++) {
			que.offer(new int[] {progresses[j],speeds[j]});
		}
		ArrayList<Integer > list = new ArrayList<Integer>();
		while(!que.isEmpty()) {
			int num =1;
			int[] arr = que.poll();
			int day = (int) Math.ceil((100-arr[0])/(double)arr[1]);
			while(true && !que.isEmpty()) {
				int[] next = que.peek();
				if((int) Math.ceil((100-next[0])/(double)next[1]) > day) break;
				que.poll();
				num++;
			}
			list.add(num);
		}
		
		int[] answer = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			answer[j] = list.get(j);
		}
        return answer;
    }
}
