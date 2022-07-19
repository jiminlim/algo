import java.util.Arrays;

public class pro_비밀지도 {
    public static void main(String[] args) {

        String[] re = solution(6, new int[]{46, 33, 33 ,22, 31, 50},new int[]{27 ,56, 19, 14, 14, 10});
        for(int r =0; r<re.length; r++){
            System.out.println(re[r]);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
//        String[] str2 = new String[n];
//        for (int i = 0; i < n; i++) {
//            str2[i] = Integer.toBinaryString(arr2[i]); //이함수를 쓰면 바로 2진수로 바꿔줌 ㅋㅅㅋ..
//        }

        //2진수 > 10진수
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        for(int i=0; i<n; i++){
            int[] changeArr1= changeNum(arr1[i],n);
            int[] changeArr2= changeNum(arr2[i],n);

            map1[i] = changeArr1;
            map2[i] = changeArr2;
        }
        //지도 그리기
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            StringBuffer sb = new StringBuffer();
            for(int j =0; j<n; j++){
                if(map1[i][j] == 0 && map2[i][j]==0){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    private static int[] changeNum(int num,int N){
        int[] arr = new int[N];
        int idx = N-1;
        while(idx>=0){
            arr[idx]=num%2;
            num = num/2;
            idx--;
        }

        return arr;
    }
}
