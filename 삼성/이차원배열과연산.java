package Baek;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 이차원배열과연산 {
    public static int A[][] ;
    public static int time;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("./src/File/이차원배열과연산"));
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(tk.nextToken())-1;
        int c = Integer.parseInt(tk.nextToken())-1;
        int k = Integer.parseInt(tk.nextToken());
        time =0;
        A = new int[3][3]; //초기는 3바이 3

        for(int i =0 ;i<3; i++){
            tk = new StringTokenizer(br.readLine());
            for(int j =0 ;j<3; j++){
                A[i][j]= Integer.parseInt(tk.nextToken());
            }
        }

        while(true)
        {
            int rlen = A.length;
            int clen = A[0].length;
            if(rlen>r && clen > c ){
                if(A[r][c] == k)
                    break;
            }
            if(time >= 100){
                time = -1;
                break;
            }
           // System.out.println(time);

            int maxlen = 0;
            ArrayList<int[]> list = new ArrayList<>();
            if(rlen >= clen){//R연산 수행
                for(int i =0; i<rlen; i++){
                    int[] new_arr = sortArr(A[i]);
                    list.add(new_arr);// 정렬한거 일단 Arraylist에 넣어둠.
                    maxlen = Math.max(maxlen,new_arr.length); //최대 길이 찾기
                }

                //크기 비교
                if(maxlen> 100) maxlen = 100;
                A = new int[rlen][maxlen];
                for(int i =0 ;i<rlen; i++){
                    int[] new_arr = list.get(i);
                    for(int j =0; j<maxlen; j++){
                        if(new_arr.length<= j){
                            A[i][j] =0;
                        }else {
                            A[i][j] = new_arr[j];
                        }
                    }
                }
            }else{//C연산 수행
                for(int j =0 ; j<clen; j++){
                    int[] arr = new int[rlen];
                    for(int i =0; i<rlen; i++){
                        arr[i] = A[i][j];
                    }
                    int[] new_arr = sortArr(arr);
                    list.add(new_arr);// 정렬한거 일단 Arraylist에 넣어둠.
                    maxlen = Math.max(maxlen,new_arr.length); //최대 길이 찾기
                }

                //크기 비교
                if(maxlen> 100) maxlen = 100;
                A = new int[maxlen][clen];
                for(int j =0 ; j<clen; j++){
                    int[] new_arr = list.get(j);
                    for(int i =0; i<maxlen; i++){
                        if(new_arr.length<= i){
                            A[i][j] =0;
                        }else {
                            A[i][j] = new_arr[i];
                        }
                    }
                }
            }
//            System.out.println("배열 정렬 후 ");
//            for(int i =0; i<A.length; i++){
//                System.out.println(Arrays.toString(A[i]));
//            }
//            System.out.println();
            time++;

        }

        System.out.println(time);

        //100초가 지나도 A[r][c] = k가 되지 않으면 -1을 출력한다.
    }

    private static int[] sortArr(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<arr.length; i++ ){
            int n = arr[i];
            if(n==0)continue;
            if(map.containsKey(n)){
                int val = map.get(n);
                map.put(n,val+1);
            }else{
                map.put(n,1);
            }
        }
        ArrayList<int[]> list = new ArrayList<>();

        for(Integer key : map.keySet()){
            int val = map.get(key);
            list.add(new int[]{key,val});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]) return -1;
                else if(o1[1] == o2[1]){
                    if(o1[0] < o2[0]) return -1;
                    else return 1;
                }else{
                    return 1;
                }
            }
        });
        int[] new_arr = new int[list.size()*2];
        for(int i =0; i<list.size(); i++){
            int[] q = list.get(i);
            new_arr[2*i] = q[0];
            new_arr[2*i+1]=q[1];
        }

        return new_arr;
    }
}
