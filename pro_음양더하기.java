public class pro_음양더하기 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{4,7,12}, new boolean[]{true,false,true}));

    }
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

         int len = absolutes.length;
         for(int i=0; i<len ;i ++){
             answer = answer + (absolutes[i]*IsSign(signs[i]));
         }

        return answer;
    }
    public static int IsSign(boolean flag){
        if(!flag) return -1;
        return 1;
    }
}
