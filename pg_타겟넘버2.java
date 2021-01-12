package day0112;

public class pg_타겟넘버2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1},3));
	}

	public static int solution(int[] numbers, int target) {
		
		return BFS(numbers, target, numbers[0],1)+
				BFS(numbers, target, -numbers[0],1); // 음수 시작
	}

	private static int BFS(int[] numbers, int target, int sum, int j) {
		if(j==numbers.length) {
			if(sum==target) {
				return 1;
			}else {
				return 0;
			}
		}
		
		int result =0;
		result += BFS(numbers, target,sum+numbers[j],j+1);
		result += BFS(numbers, target,sum-numbers[j],j+1);
		return result;
	}
}
