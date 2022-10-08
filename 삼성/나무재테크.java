package Baek;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class baek_나무재테크 {
    public static ArrayList<Integer> trees[][];
    public static int N,M,K;
    public static int[][] A,yangbun;
    public static void main(String[] args) throws Exception {
//        String path = System.getProperty("user.dir");
//        System.out.println("현재 작업 경로: " + path);

        System.setIn(new FileInputStream("./src/File/나무재테트"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        A = new int[N][N];
        yangbun = new int[N][N];
        for(int i = 0 ; i<N; i++){
            tk = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                A[i][j] = 5;
                yangbun[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        trees = new ArrayList[N][N];
        for(int i = 0 ; i<N; i++){
            for(int j =0; j<N; j++){
                trees[i][j] = new ArrayList<>();
            }
        }
        for(int i =0; i< M; i++){
            tk = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(tk.nextToken())-1;
            int y =Integer.parseInt(tk.nextToken())-1;
            int z = Integer.parseInt(tk.nextToken());
            trees[x][y].add(z);
        }


        //사계절 시작
        int year = 0;
        while (year++ < K){

            //봄//여름
            //System.out.println("봄여름");
            springSummer();

//            for(int i =0; i<N; i++){
//                for(int j =0 ; j<N; j++){
//                    System.out.print(A[i][j]+" ");
//                }System.out.println();
//            }
//            System.out.println();
//            for(int i =0; i<N; i++){
//                for(int j =0 ; j<N; j++){
//                    System.out.print(trees[i][j].size()+" ");
//                }System.out.println();
//            }
            //System.out.println();
            //가을
//            System.out.println("가을");
            fall();
//            for(int i =0; i<N; i++){
//                for(int j =0 ; j<N; j++){
//                    System.out.print(trees[i][j].size()+" ");
//                }System.out.println();
//            }
            //System.out.println();
            //겨울
            //System.out.println("겨울");
            winter();
//            for(int i =0; i<N; i++){
//                for(int j =0 ; j<N; j++){
//                    System.out.print(A[i][j]+" ");
//                }System.out.println();
//            }
        }

        int result = 0;
        for(int i =0; i<N; i++){
            for(int j =0 ; j<N; j++) {
                result += trees[i][j].size();
            }
        }
        System.out.println(result);
    }

    private static void winter() {
        for(int i =0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] += yangbun[i][j];
            }
        }
    }

    private static int dir[][] = {
            {-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}
    }; //시계방향
    private static void fall() {
        for(int i =0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                int size = trees[i][j].size();
                if(size > 0){
                    for(int k =0; k<size; k++) {
                        if(trees[i][j].get(k)%5 == 0){ //5배수이면 번식
                            // System.out.println(i+" "+j+" "+trees[i][j].get(k));
                            for(int d =0; d<8; d++){//8방향으로 나이 1나무
                                int ny = i + dir[d][0];
                                int nx = j + dir[d][1];
                                if(ny <0 || nx <0 || ny>= N || nx >= N) continue;
                                trees[ny][nx].add(1);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void springSummer() {
        for(int i =0; i<N; i++){
            for(int j =0 ; j<N; j++){
                int size  =trees[i][j].size();
                if(size > 0){
                    Collections.sort(trees[i][j]);
                    ArrayList<Integer> new_tree = new ArrayList<>();
                    int dead = 0;
                    for(int k =0; k<size; k++){
                        int year = trees[i][j].get(k);
                        //System.out.println(i+" "+j+" 나이 : "+year +" 양분:"+A[i][j]);
                        if(A[i][j] >= year){
                            A[i][j] -= year;
                            new_tree.add(year+1);
                        }else{
                            //System.out.println("죽은 나무 나이 : "+year +" 양분:"+A[i][j]);
                            dead += (year/2);// 죽은 나무 양분
                        }
                    }
                    A[i][j] += dead;
                    trees[i][j] = new_tree; //나이먹는 나무 넣기
                }
            }
        }
    }
}
