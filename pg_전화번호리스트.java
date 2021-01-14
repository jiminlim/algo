package day0114;

import java.util.Arrays;

public class pg_전화번호리스트 {
	public static void main(String[] args) {
		String[] phone_book = { "12345", "234", "4544" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length - 1; i++) {
			int len = phone_book[i].length();

			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}

		return answer;
	}
}
