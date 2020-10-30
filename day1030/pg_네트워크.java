package day1030;

public class pg_네트워크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		String str = " 	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]";
		str = str.replaceAll(" ", "");
		str = str.replace("[[", "{{");
		str = str.replaceAll("]]", "}}");
		str = str.replaceAll("]", "}");
//		System.out.println(str);
		int[][] computers = new int[][]{{1,1,0},{1,1,1},{0,1,1}};
		solution(n,computers);
	}

	static boolean[] check ;
	static int N;
	static int[][] map;
	public static int solution(int n, int[][] computers) {
		check = new boolean[n];
		map = computers;
		N = n;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if(!check[i]) {
				start(i);
				answer ++;
				
			}
		}
		System.out.println(answer);
        return answer;
    }
	private static void start(int y) {
		if(check[y]) {
			return;
		}
		for (int x = 0; x < N; x++) {
			if(y==x) continue;
			if( map[y][x] ==1) {
				check[y]=true;
				start(x);
			}
		}
	}
}
