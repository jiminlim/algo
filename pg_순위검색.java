package day0414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class pg_순위검색 {

	public static void main(String[] args) {
		String info[] = { "java backend junior pizza 150", 
				"python frontend senior chicken 210",
				"python frontend senior chicken 150", 
				"cpp backend senior pizza 260", 
				"java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println("답 : " + Arrays.toString(solution(info, query)));
	}

	public static int[] solution(String[] info, String[] query) {
		ArrayList<String[]> copy = new ArrayList<String[]>();
		for (int i = 0; i < info.length; i++) {
			String[] str = info[i].split(" ");
			copy.add(str);
		}

		int[] answer = new int[query.length];
		for (int q = 0; q < query.length; q++) {
			ArrayList<String[]> list = (ArrayList<String[]>) copy.clone();
			String[] str = query[q].split(" ");
//			System.out.println(Arrays.toString(str));
			int index = 0;
			for (int i = 0; i < str.length; i++) {
				if (str[i].equals("and"))
					continue;
				if (str[i].equals("-")) {
					index++;
					continue;
				}
				if (list.isEmpty())
					break;
				if (index == 4) {
					Iterator<String[]> iterr = list.iterator();
					while (iterr.hasNext()) {
						String[] iters = iterr.next();
//						System.out.println(iters[index] + "/" + str[i]);
						if (Integer.parseInt(str[i]) > Integer.parseInt(iters[index])) {
							iterr.remove();
						}
					}
					break;
				}else {
					Iterator<String[]> iter = list.iterator();
					while (iter.hasNext()) {
						String[] iters = iter.next();
//						System.out.println(iters[index] + "/" + str[i]);
						if (!str[i].equals(iters[index])) {
							iter.remove();
						}
					}
					index++;
				}
			}
//			System.out.println(list.size());
//			for (String[] string : list) {
//				System.out.println(Arrays.toString(string));
//			}
			answer[q] = list.size();
		}
		return answer;
	}
}