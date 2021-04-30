package day0428;

public class pg_�űԾ��̵���õ {

	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
//		String new_id = "...!@BaT#*..y.abcdefghijklm.";
		System.out.println("answer : " + solution(new_id));
	}

	public static String solution(String new_id) {
		// 1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		new_id = new_id.toLowerCase();
		System.out.println(new_id);
		StringBuilder sb = new StringBuilder(new_id);
		int idx = 0, point = -1;
		while (idx < sb.length()) {
			char data = sb.charAt(idx);
			// 2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
			// -_.~!@#$%^&*()=+[{]}:?,<>/
			if (!((data >= 'a' && data <= 'z')|| (data >= '0' && data <= '9') || (data == '.') || (data == '-') || (data == '_'))) {
				sb.deleteCharAt(idx);
			} else {
				// 3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
				if (data == '.' && point != -1) {
					sb.deleteCharAt(idx);
					continue;
				} else {
					point = -1;
				}
				if (data == '.') {
					point = idx;
				}
				idx++;
			}
		}
		System.out.println(sb.toString());
		int len = sb.length();
		// 4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		if (len > 0 && sb.charAt(0) == '.') {
			sb.deleteCharAt(0);
		}
		// ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		if (len > 1 && sb.charAt(sb.length() - 1) == '.') {
			sb.deleteCharAt(sb.length() - 1);
		}
		// 5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		if (sb.length() == 0) {
			sb.append("a");
		}
		
		System.out.println(sb.toString());
		// 6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
		if (sb.length() > 15) {
			sb.delete(15, sb.length());
			if(sb.charAt(sb.length()-1) == '.') {
				sb.deleteCharAt(14);
			}
		}
		
		// 7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
		len = sb.length();
		if (sb.length() < 3) {
			while (sb.length() < 3) {
				sb.append(sb.charAt(len-1));
			}
		}
		System.out.println("last : " + sb.toString());

		return sb.toString();
	}

}
