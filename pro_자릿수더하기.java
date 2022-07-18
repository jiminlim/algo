public class pro_자릿수더하기 {
    public static void main(String[] args) {
        System.out.println(solution(123));

    }
    public static int solution(int n) {
        int answer = 0;

        while(n > 9){
            answer += n % 10;
            n = n/ 10;
        }

        return answer + n;
    }
}
