public class Test2 {
    public static void main(String[] args) {
        
        int[] registered_list = new int[]{2, 6, 17, 29};
        
        int leave=3;
         String day = "SUN";

        System.out.println( solution(leave, day,registered_list));
    }

    public static int solution(int leave, String day, int[] holidays) {

        int map[][] =new int[6][7];
        String[] days = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int start = 0;
        for(int i=0; i<7; i++){
            if(days[i].equals(day)){
                start = i;
                break;
            }
        }

        int num =1;
        for(int i = start; i<7;i++){
            map[0][i] = num++;
        }
        for(int i=1; i<6; i++){
            for(int j =0; j<7; j++){
                if(num >30) break;
                map[i][j]=num++;
            }
        }

        int idx =0;
        for(int i=0; i<6; i++){
            for(int j =0; j<7; j++){
                if(idx < holidays.length && holidays[idx]==map[i][j]){
                    idx++;
                    map[i][j] = -1;
                }             
                if(map[i][j]!=0 && (j==0 || j == 6))   
                    map[i][j] = -1;
            }
        }
        

        for(int i=0; i<6; i++){
            for(int j =0; j<7; j++){
                System.out.print(map[i][j]+" ");
                
            }System.out.println();
        }
        int max =0;
        for(int i=0; i<6; i++){
            for(int j =0; j<7; j++){
                if(map[i][j] == 0 ) continue;
                max = Math.max(max, countDays(map,i,j,leave));     
            }
        }

        return max;
    }

    private static int countDays(int[][] map, int i, int j,int leave) {
        int cnt = leave;
        int num=0;
        while(cnt >=0){
            if(map[i][j] ==0) break;
            if(map[i][j] != -1){
                cnt --;
            }
            if(cnt >= 0 ) num++;
            j++;
            if(j>6){
                j=0;
                i++;
            }
        }

        return num;
    }
}
