package day1010;

import java.util.Arrays;

public class pg_k¹øÂ°¼ö {

	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int []  result = solution(array, commands);
		System.out.println(Arrays.toString(result));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int n = 0; n < commands.length; n++) {
			int i = commands[n][0]-1;
			int j = commands[n][1];
			int k = commands[n][2]-1;

			int [] arr = new int[j-i];
			for (int m = i, num =0; m < j; m++, num++) {
				arr[num]=array[m];
			}
			Arrays.sort(arr);
			answer[n] = arr[k];
			
		}
		
		return answer;
	}
}
