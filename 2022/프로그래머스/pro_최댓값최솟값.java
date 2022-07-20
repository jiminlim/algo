import java.util.*;

public class pro_최댓값최솟값 {
    public static void main(String[] args) {
        System.out.println(solution("-1 -1"));
    }
    public static String solution(String s) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                if(s.charAt(i) == '-') {
                    String ss = Character.toString(s.charAt(i)) + Character.toString(s.charAt(i+1));
                    list.add(Integer.parseInt(ss));
                    i++;
                }else{
                    list.add(Character.getNumericValue(s.charAt(i)));
                }
            }

        }
        Collections.sort(list);


        String answer = list.get(0) + " " + list.get(list.size()-1);

        return answer;
    }

    public static String solution2(String s) {

        //끊기
        String[] arr = s.split(" ");
        int max =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        for(int i= 0; i< arr.length; i++){
            int num = Integer.parseInt(arr[i]);

            max = Math.max(max,num);
            min = Math.min(min, num);

        }

        String answer = min+" "+max;
        return answer;
    }
}
