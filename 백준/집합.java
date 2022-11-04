package Baek;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        HashSet<Integer> set = new HashSet<>();
        StringBuilder  sb = new StringBuilder();
        for(int n =0; n<N; n++){
            s = br.readLine();
            //System.out.println(n+" "+s);

            String[] arr = s.split(" ");
            String cal = arr[0];
            if(arr.length == 1){
               // System.out.println(cal);
                if(cal.equals("all")){
                    set.clear();
                    for(int i =1 ; i<=20; i++){
                        set.add(i);
                    }
                }else if(cal.equals("empty")){
                    set.clear();
                }

            }else{
                int num = Integer.parseInt(arr[1]);
                //System.out.println(">>> "+cal+" "+num);
                if(cal.equals("add")){
                    set.add(num);
                }else if(cal.equals("remove")){
                    set.remove(num);
                }else if(cal.equals("check")){
                    if(set.contains(num)) sb.append(1+"\n");
                    else sb.append(0+"\n");
                }else if(cal.equals("toggle")){
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                }
            }

        }
        System.out.println(sb);
    }
}
