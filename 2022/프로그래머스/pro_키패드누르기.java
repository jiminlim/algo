public class pro_키패드누르기 {

    public static void main(String[] args) {
        String r = solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left" );
        System.out.println(r);
    }

    public static String solution(int[] numbers, String hand) {
        String answer ="";
        //시작
        int left[] = new int[]{3,0};
        int right[] = new int[]{3,2};


        for(int i=0; i<numbers.length; i++){
            if(numbers[i] % 3 == 1 ){ // 왼쪽 손 움직여
                left[0] = numbers[i]/3;
                left[1] = 0;
                answer += "L";
            }
            else if(numbers[i] != 0 &&  numbers[i] % 3 == 0){ // 오른쪽 손 움직여
               right[0] = numbers[i]/3-1;
                right[1] =2;
                answer += "R";
            }else{
                int dest[] = new int[2];
                if(numbers[i] == 0){
                    dest[0] = 3; dest[1] = 1;
                }else{
                    dest[0] = numbers[i]/3;
                    dest[1] = numbers[i]%3-1;
                }

                int left_distance = Math.abs(dest[0] - left[0]) + Math.abs(dest[1] - left[1]);
                int right_distance = Math.abs(dest[0] - right[0]) + Math.abs(dest[1] - right[1]);

                if(left_distance < right_distance){
                    left[0] = dest[0];
                    left[1] = dest[1];
                    answer += "L";
                }else if(left_distance == right_distance){
                    if(hand.equals("right")){
                        right[0] = dest[0];
                        right[1] = dest[1];
                        answer += "R";
                    }else{
                        left[0] = dest[0];
                        left[1] = dest[1];
                        answer += "L";
                    }
                }else{
                    right[0] = dest[0];
                    right[1] = dest[1];
                    answer += "R";
                }
            }

//            for(int ii=0;ii<4; ii++){
//                for(int jj =0; jj<3; jj++){
//                    System.out.print(map[ii][jj]+" ");
//                }System.out.println();
//            }
//
//            System.out.println();
        }

        return answer;
    }
}
