import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero =0;
        Set set=new HashSet();
        for(int i =0 ;i < 6; i++){
            set.add(win_nums[i]);
        }
        
         for(int i =0 ;i < 6; i++){
             if(lottos[i] == 0){
                 zero ++;
                 continue;
             }
            set.add(lottos[i]);
        }
       
        int correct = (12-set.size()-zero);
        int max = 7-( correct+ zero);
        int min = 7-correct;
        
        System.out.println(set.size());
        
        if(max  == 7) max = 6;
        if(min == 7)min = 6;
        int[] answer = {max, min};
        return answer;
    }
}
