package day0422;

import java.util.Arrays;
import java.util.Stack;

public class pg_크레인인형뽑기 {
// 4 
	public static void main(String[] args) {
		int[][] board= {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
				};
		int[][] board2 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,1,0,0,1}};
		int[] moves= {1,5,3,5,1,2,1,4};
		int[] moves1 = {1,1};
		System.out.println(solution(board2, moves1));
	}

	public static int solution(int[][] board, int[] moves) {
		int len = board.length;
        int[] picklist = new int[len];
        Arrays.fill(picklist, -1);
        for (int j = 0; j < len; j++) {
        	for (int i = 0; i < len; i++) {
				if(board[i][j]!= 0) {
					picklist[j]=i;
					break;
				}
			}
		}
		int answer = 0;
		Stack<Integer> stack = new Stack<Integer>();
		//뽑기 시작
		for (int i = 0; i < moves.length; i++) {
			int idx = moves[i]-1;
			if(picklist[idx]==-1) continue;
			//뽑아서 stack에 넣어
			int pick = board[picklist[idx]][idx];
			board[picklist[idx]][idx]=0; // 인형없애
			print(board);
			
			picklist[idx]++;
			if(picklist[idx] == len) picklist[idx] = -1;
			if(!stack.isEmpty()) {
				if(stack.peek() == pick) {
					stack.pop();
					answer+=2;
				}else {
					stack.push(pick);
				}
			}else {
				stack.push(pick);
			}
			//stack의 맨위가 픽한거랑 같으면 없어져 answer+2;
		}
        return answer;
    }

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
	}
}
