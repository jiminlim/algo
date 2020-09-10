package day0910;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class pg_후보키 {
	static HashMap<String, Boolean> map;
	static ArrayList<Integer> list;
	static Queue<Integer> que;
	static int y, x, answer;
	static String[][] data;
	static boolean change;

	public static int solution(String[][] relation) {
		y = relation.length;
		x = relation[0].length;
		data = relation;
		answer = 0;
		change = false;
		list = new ArrayList<>();
		que = new LinkedList<>();
		map = new HashMap<>();

		for (int i = 0; i < x; i++) {
			list.add(i);
		}
		for (int i = 1; i < x; i++) {
			if (i >= list.size()) {
				break;
			}
			int[] num = new int[i];
			combi(list.size(), num, 0, 0);


			if (que.size() != 0) {
				int z=1;
				while (!que.isEmpty()) {
//					System.out.println(que.peek());
					int del = que.poll();
					list.remove(del-z);
					z++;

				}
				que.clear();
			}
		}

		return answer;
	}

	private static void combi(int n, int[] num, int start, int cnt) {
		if (cnt == num.length) {
			// 출력
			check(num);
			map.clear();
			if (change) {
				for (int i = 0; i < num.length; i++) {
					if(que.contains(num[i])) {
						continue;
					}
					que.offer(num[i]);
				}
				change = false;
			}
			
			return;
		}
		for (int i = start; i < n; i++) {
			num[cnt] = list.get(i) + 1;
			combi(n, num, i + 1, cnt + 1);
		}
	}

	private static void check(int[] num) {
		for (int i = 0; i < y; i++) {
			String str = "";

			for (int j = 0; j < num.length; j++) {
				str += data[i][num[j] - 1];
			}
			map.put(str, true);
		}
		if (map.size() == y) { // 중복 된것이 없다.
			answer++;
			change = true;
		}
	}

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };
		int answer = solution(relation);
		System.out.println(answer);
	}

}
