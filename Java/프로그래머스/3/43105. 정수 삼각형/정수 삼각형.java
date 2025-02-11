class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=i; j++){
                int left=0;
                int right=0;
                if (j-1>=0) left = dp[i-1][j-1];
                right = dp[i-1][j];
                int big = Math.max(left, right);
                dp[i][j] = big+triangle[i][j];
            }
        }
        for(int i = 0; i<n ; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}