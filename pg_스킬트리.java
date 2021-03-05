package day0305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class pg_��ųƮ�� {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //�迭�� ����Ʈ�� ��������. 
        Iterator<String> it = skillTrees.iterator();
        // ���ͷ����� 
//        hasNext() : �о�� ��Ұ� �����ִ��� Ȯ���ϴ� �޼ҵ��̴�. ��Ұ� ������ true, ������ false
//        next() : ���� �����͸� ��ȯ�Ѵ�.
//        remove() : next()�� �о�� ��Ҹ� �����Ѵ�.
        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
	
//	private static int solution(String skill, String[] skill_trees) {
//		int answer = 0;
//		int s = skill.length();
//		for (int i = 0; i < skill_trees.length; i++) {
//			boolean[] alpha = new boolean[26];
//			String str = skill_trees[i];
//			for (int j = 0; j < str.length(); j++) {
//				alpha[str.charAt(j)-'A'] = true;
//			}
//			int cnt =0;
//			for (int j = 0; j < s; j++) {
//				if(alpha[skill.charAt(j)-'A']) {
//					cnt++;
//				}
//			}
//			int s_cnt=0;
//			for (int j = 0; j < str.length(); j++) {
//				if(s_cnt==cnt) {break;}
//				if(skill.charAt(s_cnt)==str.charAt(j)) {
//					s_cnt++;
//				}
//			}
//			
//			if(s_cnt == cnt) {answer++;}
//		}
//		
//		return answer;
//	}

}