import java.util.Arrays;

public class pg_없는숫자더하기 {
    public static void main(String[] args) {
        int r = solution(new int[]{1,2,3,4,6,7,8,0} );
        System.out.println(r);
    }

    public  static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        int idx =0;
        int list_len = numbers.length;
        for(int i=0; i<10; i++){

            if( list_len>idx &&  numbers[idx]==i){
                System.out.println(numbers[idx]+" "+i);
                idx++;
            }else{
                System.out.println(i);
                answer+= i;
            }
        }

        return answer;
    }
}
