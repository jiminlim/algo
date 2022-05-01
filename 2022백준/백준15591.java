import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 백준15591{
    static int N;
    static char[][] map;
    static List<int[]> blank, teachers;
    public static void main(String[] args) throws Exception{
        //완탐 가능
        System.setIn(new FileInputStream("C:/Project/algorithm/0429/file"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        map = new char[N][N];
        blank = new ArrayList<>();
        teachers = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                map[i][j] = tk.nextToken().charAt(0);

                if(map[i][j]=='X'){
                    blank.add(new int[]{i,j});
                }
                else if(map[i][j] == 'T'){
                    teachers.add(new int[]{i,j});
                }
            }
        }

        //빈칸들중 3개 뽑아 -- combi
        pickThreeBlack(blank.size(),3,0,0,new int[3]);
        System.out.println("NO");
    }
    private static void pickThreeBlack(int n, int r, int start, int cnt,int[] arr) {
        if(cnt == r){
            checkBlankForBlockTeachers(arr);
            return;
        }

        for(int i = start; i<n;i++){
           arr[cnt] = i;
            pickThreeBlack(n, r, i+1, cnt+1,arr);
        }
    }
    private static void checkBlankForBlockTeachers(int[] arr) {
        // if(arr[0]==1 && arr[1]==3 && arr[2]==8){
        //     System.out.println("ddddddddddddddddddd");
        // }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString( blank.get(arr[0]))+" "+Arrays.toString( blank.get(arr[1]))+" "+Arrays.toString( blank.get(arr[2])) );
        for(int i=0; i<3;i++){
            int[] position = blank.get(arr[i]);

            map[position[0]][position[1]]='O';
        }

        boolean stopFlag = checkTeachersDetect();

        if(!stopFlag){
            //멈췃! 성공
            System.out.println("YES");
            System.exit(0);
        }

        for(int i=0; i<3;i++){ //복구
            int[] position = blank.get(arr[i]);
            map[position[0]][position[1]]='X';
        }
    }

    private static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    private static boolean checkTeachersDetect() {
        int[] pos = new int[2] ;
        // Queue<int[]> que = new LinkedList<>();
        for(int i=0; i<teachers.size(); i++){
            pos = teachers.get(i);
            for(int d =0; d<4;d++){
                int next_y = pos[0]+dir[d][0];
                int next_x = pos[1]+dir[d][1];
                // System.out.println(next_y+" "+next_x);
                while(next_y>=0 && next_y<N && next_x >=0 && next_x< N){
                    if(map[next_y][next_x]=='S'){
                        return true;
                    }else if (map[next_y][next_x] =='O'){
                        break;
                    }

                    next_y = next_y+dir[d][0];
                    next_x = next_x+dir[d][1];
                }
            }
            
        }
       
        return false;
    }
}
