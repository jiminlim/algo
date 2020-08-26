package day0826;

import java.util.ArrayList;
import java.util.HashMap;

public class pg_����ä�ù� {

	public static String[] solution(String[] record) {
		String[] answer = {};
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			int idx1 = record[i].indexOf(" ");
			int idx2 = record[i].lastIndexOf(" ");
			switch (record[i].substring(0, idx1)) {
			case "Enter": 
				map.put(record[i].substring(idx1 + 1, idx2), record[i].substring(idx2 + 1));
				list.add(record[i].substring(idx1 + 1, idx2)+"���� ���Խ��ϴ�.");
				break;
			case "Leave":
				list.add(record[i].substring(idx1 + 1)+"���� �������ϴ�.");
				break;
			case "Change":
				map.put(record[i].substring(idx1 + 1, idx2), record[i].substring(idx2 + 1));
				break;

			}
		}
		answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			int idx = list.get(i).indexOf("��");
			answer[i] = map.get(list.get(i).substring(0, idx))+list.get(i).substring(idx);
		}

		
		return answer;
	}

	// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] str = solution(record);
		for (String string : str) {
			System.out.println(string);
		}
	}
}
