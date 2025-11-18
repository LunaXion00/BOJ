import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        // 첫번째 행 초기화
        for(int i = 0; i < 4; i++) dp[0][i] = land[0][i];
        // 두번째 행부터 누적
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 4; j++) {
                // 직전 행에서 j를 제외한 최대값 찾기
                int maxPrev = 0;
                for(int k = 0; k < 4; k++) {
                    if(k == j) continue;
                    maxPrev = Math.max(maxPrev, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + maxPrev;
            }
        }
        // 마지막 행에서 최대값
        for(int i = 0; i < 4; i++) answer = Math.max(answer, dp[n-1][i]);
        return answer;
    }
}