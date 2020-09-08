package day0908;

public class pg_카카오프랜즈컬러링북 {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}}; //우 좌 하 상
	static boolean[][] check;
	static int count =0;
	static int[][] map ;
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; //몇개 영역
        int maxSizeOfOneArea = 0; // 제일 큰 사이즈
        check = new boolean[m][n];
        map = picture;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
				if(!check[i][j]&& picture[i][j]!=0) {
					check[i][j]=true;
					count =1;
					dfs(i,j,m,n,picture[i][j]);
					numberOfArea++;
					if(count > maxSizeOfOneArea) {
						maxSizeOfOneArea=count;
					}
				}
			}
		}
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	private static void dfs(int y, int x,int m, int n, int val) {
		for (int d = 0; d < 4; d++) {
			int ny= y+dir[d][0];
			int nx = x+dir[d][1];
			if(ny>=0 && nx>=0 && ny<m && nx<n && !check[ny][nx]&& val==map[ny][nx]) {
				check[ny][nx]=true;
				count++;
				dfs(ny,nx,m,n,val);
			}
		}
	}
	public static void main(String[] args) {
		int[][] pictures = 
			{{1, 1, 1, 0}, 
			{1, 2, 2, 0}, 
			{1, 0, 0, 1}, 
			{0, 0, 0, 1}, 
			{0, 0, 0, 3}, 
			{0, 0, 0, 3}};
		
		int[] str = solution(6,4, pictures);
		System.out.println("----------결과물---------------- ");
		for (int i : str) {
			System.out.print(i + " ");
		}
	}

}
