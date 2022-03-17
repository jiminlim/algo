import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int input_len = sc.nextInt();
		List<String> text_list = new ArrayList();
		boolean[] isJubdu = new boolean[input_len];
		for(int i=0;i<input_len; i++) {
			String input_text = sc.next();			
			text_list.add(input_text);
		}
		
		
		for(int i=0;i<input_len; i++) {
			String compare_text = text_list.get(i);
			
			boolean flag = false;
			for(int j=0; j<input_len;j++) {
				if(i==j)continue;
				if(isJubdu[j]) continue; // 비교대상
				String compare_next_text = text_list.get(j);
				
				if(isJubdu(compare_text, compare_next_text)) {
					isJubdu[i] = true;
				}
				
			}
			
		}
		int result_count = 0;
		for(int i=0;i<input_len;i++) {
			if(!isJubdu[i]) {
				result_count++;
			}
		}
		        
		System.out.println(result_count);
		

	}

	private static boolean isJubdu(String compare_text, String compare_next_text) {
		int compare_len = compare_text.length();
		int compare_next_len = compare_next_text.length();
		
		if(compare_len > compare_next_len) return false; 
		
		for(int i=0; i<compare_len; i++) {
			char compare_char = compare_text.charAt(i);
			char compare_next_char = compare_next_text.charAt(i);
			if(compare_char!=compare_next_char) {
				return false;
			}
		}
		return true;
	}

}
