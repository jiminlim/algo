package day0908;

import java.util.Arrays;

public class pg_����˻� {

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
//			System.out.println("--------------query : "+queries[i]+"----------");
			// ��
			int query_len = queries[i].length();
			char[] query = new char[query_len];
			boolean[] questionmark = new boolean[query_len];
			for (int j = 0; j < query_len; j++) {
				if (queries[i].charAt(j) != '?') {
					questionmark[j] = true;
					query[j] = queries[i].charAt(j);
				}
			}
			
			for (int j = 0; j < words.length; j++) {
				int word_len = words[j].length();
				if (query_len != word_len) { // ���̰� �ٸ��� ���� �ܾ��
					continue;
				}
//				System.out.println("word : "+words[j]);
				boolean next_word = false;
				for (int k = 0; k < word_len; k++) {
					if(questionmark[k]) {
//						System.out.println(query[k]+" / "+words[j].charAt(k));
						if(query[k]!=words[j].charAt(k)) {
							next_word=true;
							break;
						}
					}
				}
				if(!next_word) {
					answer[i]++;
				}

			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

		int[] str = solution(words, queries);
		System.out.println("----------�����---------------- ");
		for (int i : str) {
			System.out.print(i + " ");
		}
	}

}
