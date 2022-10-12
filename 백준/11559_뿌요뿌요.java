package Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.*;

public class PuyoPuyo {
    public static char[][] map;
    public static int cnt;
    public static void main(String[] args)  throws Exception {
        System.setIn(new FileInputStream("./src/File/뿌요"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //map
        map = new char[12][6];
        cnt = 0;

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
            }
        }

        while (true) {
            //BFS 뿌요 찾아 map에서 .으로 바꿔
            boolean stop = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    char c = map[i][j];
                    if(c=='.')continue;
                    boolean flag = BFS(i,j); // stop 한번이라도 뿌요 되면  true
                    if(flag == true) stop = true; //한번이라도 연쇄되면
                    //끝나면 1연쇄!

                }
            }

            //뿌요 끝났어
//            System.out.println("bfs 결과 ");
//            for(int a =0 ; a<12; a++){
//                for(int b =0 ;b<6; b++){
//                    System.out.print(map[a][b]+" ");
//                }System.out.println();
//            }

            //제어
            if(stop){
                //중력 떨어져 (밑에서 부터 찾아 .이야? 그럼 맨위가 될때까지 반복 )
                for(int i=0; i<6;i++){
                    down(i);
                }
//                System.out.println("down 결과 ");
//                for(int a =0 ; a<12; a++){
//                    for(int b =0 ;b<6; b++){
//                        System.out.print(map[a][b]+" ");
//                    }System.out.println();
//                }

                cnt++;
            }
            else{
                break;
            }
        }

        System.out.println(cnt);
//        System.out.println("최종 결과 ");
//        for(int a =0 ; a<12; a++){
//            for(int b =0 ;b<6; b++){
//                System.out.print(map[a][b]+" ");
//            }System.out.println();
//        }
    }
    public static void down(int x){
        ArrayList<Character> list = new ArrayList<>();
        //밑에서 부터 .이면
        for(int i= 11; i>=0 ;i--){
            if(map[i][x] != '.') {
                list.add(map[i][x]);
                map[i][x] = '.';
            }
        }
        int y = 11;
        for(int i= 0; i<list.size(); i++){
            map[y][x] = list.get(i);
            y--;
        }
    }
    public static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우
    public static boolean BFS(int i , int j){
        Queue<Pyu> que = new LinkedList<>();
        que.add(new Pyu(i,j, map[i][j]));

        char[][] newmap = new char[12][6];
        for(int k =0; k<12; k++){ //복사해
            newmap[k] = map[k].clone();
        }

        int count = 0;
        while(!que.isEmpty()){
            Pyu q = que.poll();
            for(int d =0 ;d<4; d++){
                int ny = q.y + dir[d][0];
                int nx = q.x + dir[d][1];

                if(ny< 0 || nx<0|| ny>= 12 || nx>=6) continue;
                if(newmap[ny][nx]=='.')continue;
                if(newmap[ny][nx]!=q.c) continue; // 같은 색 아니면
               // System.out.println("next : "+ny+" "+nx+" "+newmap[ny][nx]);
                count++;
                newmap[ny][nx] = '.';

                que.offer(new Pyu(ny,nx,q.c));
            }
        }


        if(count >= 4){ // map에 적용해
            map = newmap;
            return true;
        }
        else {
            return false;
        }
    }
    static class Pyu {
        int y ; int x; char c;
        public Pyu(int y, int x, char c){
            this.y = y; this.x = x; this.c = c;
        }
    }
}
