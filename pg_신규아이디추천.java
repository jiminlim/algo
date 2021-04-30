package day0428;

public class pg_신규아이디추천 {

	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
//		String new_id = "...!@BaT#*..y.abcdefghijklm.";
		System.out.println("answer : " + solution(new_id));
	}

	public static String solution(String new_id) {
		// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		new_id = new_id.toLowerCase();
		System.out.println(new_id);
		StringBuilder sb = new StringBuilder(new_id);
		int idx = 0, point = -1;
		while (idx < sb.length()) {
			char data = sb.charAt(idx);
			// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
			// -_.~!@#$%^&*()=+[{]}:?,<>/
			if (!((data >= 'a' && data <= 'z')|| (data >= '0' && data <= '9') || (data == '.') || (data == '-') || (data == '_'))) {
				sb.deleteCharAt(idx);
			} else {
				// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
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
		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		if (len > 0 && sb.charAt(0) == '.') {
			sb.deleteCharAt(0);
		}
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (len > 1 && sb.charAt(sb.length() - 1) == '.') {
			sb.deleteCharAt(sb.length() - 1);
		}
		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (sb.length() == 0) {
			sb.append("a");
		}
		
		System.out.println(sb.toString());
		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		if (sb.length() > 15) {
			sb.delete(15, sb.length());
			if(sb.charAt(sb.length()-1) == '.') {
				sb.deleteCharAt(14);
			}
		}
		
		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
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
