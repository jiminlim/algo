import java.util.HashMap;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        String[] registered_list = new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
        String new_id = "cow";

        solution(registered_list,new_id);

    }
    
    public static String solution(String[] registered_list, String new_id) {

        //new id 확인
        //n,s 나눔
        
        HashSet<String> set = new HashSet<>();
        for(int i =0; i<registered_list.length; i++){
            set.add(registered_list[i]);
        }

        int s1 =0;
        for(int i=0; i<new_id.length();i++){
            char a = new_id.charAt(i);
            if(Character.isDigit(a)){
                s1 = i;break;
            }
        }
        String N = "";
        String S = "";
        if(s1 != 0){
            N = new_id.substring(s1, new_id.length());
            S = new_id.substring(0, s1);
        }else{
            S = new_id;
        }
        
        System.out.println(S+" "+N);


        while(find(new_id,set)){
            //추천
            //N을 10진수 변환  > +1  

            if(N.length() ==0){
                N = "1";
                new_id+=N;                
            }else{
                int n = Integer.parseInt(N)+1;
                N = n+"";
                new_id = S+n;
            }
            System.out.println(new_id);
        }
        
        return new_id;
    }

    private static boolean find(String new_id, HashSet<String> set) {
                //아이디 비교 
            if(set.contains(new_id)){
                return true;
            }
            return false;
    }
}
