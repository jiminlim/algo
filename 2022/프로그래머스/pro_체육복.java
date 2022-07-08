import java.util.*;
public class pro_체육복 {
    public static void main(String[] args) {

        int answer = solution(5,new int[]{2,4},new int[]{1,3,5});
        System.out.println(answer);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;

        Arrays.sort((lost));
        Arrays.sort(reserve);

        //도난 당했는데 여벌있어
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i]= -1;
                    reserve[j] = -1;
                }
            }
        }

        //도난 당했는데 여벌 빌려줘
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length;j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
