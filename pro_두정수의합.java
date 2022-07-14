public class pro_두정수의합 {
    public static void main(String[] args) {
        System.out.println(solution(3,5));
    }
//23456 - 8 > 4 - 0
    //234 - 6 > 3 -0
    //2345 - 7 > 3 - 1
    //345 - 8 >  (5-3) + 1
    public static long solution(long a, long b) {
        return (long)(a+b)*(Math.abs(a-b)+1)/2;
    }
}
