package day1019;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class sw10888_음식배달 {
	static int N,answer;
//	static int[][] map;
	static ArrayList<int[]> franchiseeLoc, houseLoc;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/day1019/음식배달"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		TC =3;
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = Integer.MAX_VALUE;
//			map = new int[N+1][N+1];
			franchiseeLoc = new ArrayList<>();
			houseLoc = new ArrayList<>();
			int numOfFran =0;
			for (int i = 1; i < N+1; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					int val = Integer.parseInt(tk.nextToken());
					if(val==1) {
						houseLoc.add(new int[] {i,j});
					}else if(val != 0) {
						numOfFran++;
						franchiseeLoc.add(new int[] {i,j,val});
					}
				}
			}
//			System.out.println(numOfFran);
			
			//프랜차이즈 갯수 조합
			for (int i = 1; i <= numOfFran; i++) {
				int[] franchisee = new int[i];
				findfranchise(numOfFran,i,0,0,franchisee);
			}
			
			
			System.out.println("#"+(tc+1)+" "+answer);
		}
		
	}
	private static void findfranchise(int n, int r, int start, int cnt, int[] franchisee) {
		if(cnt == r) {
//			System.out.println(Arrays.toString(franchisee));
			//나온 프랜차이즈 돌려서 최소값 구함
			int returnmin = findAnswer(franchisee);
			if(answer>returnmin) {
				answer = returnmin;
			}
			return ;
		}
		
		for (int i = start; i < n; i++) {
			franchisee[cnt] = i;
			findfranchise(n, r, i+1, cnt+1, franchisee);
		}
	}
	private static int findAnswer(int[] franchisee) {
		int returnval =0;
		boolean[] use = new boolean[franchisee.length];
		for (int i = 0; i < houseLoc.size(); i++) {
			int[] loc = houseLoc.get(i);
			int y = loc[0]; int x = loc[1];
			
//			System.out.println("house ; "+y+" "+x);
			
			int min =Integer.MAX_VALUE;
			for (int j = 0; j < franchisee.length; j++) {
				int[] floc = franchiseeLoc.get(franchisee[j]);
				int fy = floc[0]; int fx = floc[1];
//				System.out.println("fran ; "+fy+" "+fx);
				
				int val = Math.abs(fy-y)+Math.abs(fx-x);
//				System.out.println(val);
				if(min>val) {
					min = val;
					use[j]=true;
				}
			}
			
			returnval += min;
//			System.out.println("--------finish : "+returnval+" "+min);
			
		}
		
		for (int i = 0; i < use.length; i++) {
			if(use[i]) {
				int fee = franchiseeLoc.get(franchisee[i])[2];
				returnval += fee;
			}
		}
		
		return returnval;
	}

}
