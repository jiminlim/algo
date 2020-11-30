package day1130;
import java.util.*;
public class pg소수찾기 {

	public static void main(String[] args) {
		System.out.println(solution("015"));
	}

	static HashSet<Integer> map;
    public static int solution(String numbers) {
        int n = numbers.length();
        char[] num = new char[n];
        for(int i=0;i<n;i++){
            num[i] = numbers.charAt(i);
        }
        
        //순열
        boolean[] check = new boolean[n];
        int[] pem ;
        int answer = 0;
        map = new HashSet<>();
        for(int r =1; r<=n; r++){
            pem = new int[r];
            permu(n,r,0,pem,check,num);
        }
        answer = isPrime(map);
        //sqrt로 제곱근 까지 찾기 
        
        return answer;
    }
    public static int isPrime(HashSet<Integer> map){
        int result =0;
        Iterator<Integer> it=map.iterator();
    	while(it.hasNext()){
    		int num = it.next();
        	if(num==2) {result ++;continue;}
        	if(num ==1 ||num % 2 == 0) continue;
        	boolean f = false;
            for(int i =3; i<=Math.sqrt(num);i+=2){
                if(num%i ==0) {f =true; continue;}
            }
            if(!f) result ++;
        }
        return result;
    }
    public static void permu(int n,int r, int cnt, int[] num, boolean[] check ,char[] in){
        if(r==cnt){
            if(in[num[0]] != '0' ) {
                String input ="";
                for(int i =0; i< r;i++)
                    input += in[num[i]];
                
                map.add(Integer.parseInt(input));
                
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!check[i]){
                check[i] = true;
                num[cnt] = i;
                permu(n,r,cnt+1,num,check,in);
                check[i] = false;
            }
        }
    }
}
