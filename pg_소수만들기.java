package day0423;

public class pg_소수만들기 {

	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4 };
		System.out.println(solution(nums));
	}

	static int answer ;
	public static int solution(int[] nums) {
		answer = 0;
		combi(nums,nums.length,0,0,0);
		

		return answer;
	}
	private static void combi(int[] nums, int n,int start, int cnt, int sum) {
		if(cnt==3) {
			find(sum);
			return;
		}
		
		for (int i = start; i < n; i++) {
			combi(nums,n,i+1,cnt+1,sum+nums[i]);
		}
	}
	private static void find(int sum) {
		//소수 판별
		if(sum%2 == 0) return;
		
		int num = (int) Math.sqrt(sum);
		if(num < 3) {
			answer ++; return;
		}
		for (int i = 3; i <= num; i++) {
			if(sum%i == 0) return;
		}
		answer++;
	}
}
