package day1124;

import java.util.*;

public class pg_�Ҽ�ã�� {

	public static void main(String[] args) {
		solution("17");
	}

	static HashMap<Integer, Integer> map;

	public static int solution(String numbers) {
		int answer = 0;
		map = new HashMap<>();
		// �Է� �� �޺� �������� ������ŭ
		char[] com = null;
		boolean[] visit = new boolean[numbers.length()];
		for (int i = 1; i <= numbers.length(); i++) {
			com = new char[i];
			permu(numbers.length(), i, 0, com, visit, numbers);
		}

		// ���� ������ 2���� �Ҽ����� Ȯ��
		answer = map.size();
		System.out.println(answer);
		return answer;
	}

	public static void permu(int n, int r, int cnt, char[] com, boolean[] visit, String numbers) {
		if (cnt == r) {
			 isPrime(com,numbers);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i] != true) {
				visit[i] = true;
				com[cnt] =numbers.charAt(i);
				permu(n, r, cnt + 1, com, visit, numbers);
				visit[i] = false;
			}
		}
	}

	public static void isPrime(char[] com, String numbers) {
		
		String n = "";
		if (com[0] == '0')
			return;
		if (com.length == 1 && com[0] == '1')
			return;
		for (int i = 0; i < com.length; i++) {
			n += com[i];
		}

		int num = Integer.parseInt(n);
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return;
			}
		}
		map.put(num, num);
	}
}
