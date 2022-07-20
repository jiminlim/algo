import java.util.Stack;

public class pro_3진법뒤집기 {
    public static void main(String[] args) {
        System.out.println(solution(125));
    }
    public static int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;

        while(true){
            count++;
            stack.add(n%3);
            n = n / 3;
            if(n == 0)break;
        }

        for(int i=0; i<count; i++){
            answer += stack.pop() * (Math.pow(3,i));
        }

        return answer;
    }
}
