class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
       int M = arr1.length;
        int N = arr2[0].length;
        int len = arr1[0].length;
        int [][] answer = new int[M][N];
        
        for(int m=0; m< M; m++){
            for(int n =0; n<N; n++){
                int sum =0;
                //연산 한다. 
                
                for(int i =0 ;i< len; i++){
                    sum += arr1[m][i]* arr2[i][n];
                }
                
                answer[m][n] = sum;
            }
        }
        
        
        return answer;
    }
}
