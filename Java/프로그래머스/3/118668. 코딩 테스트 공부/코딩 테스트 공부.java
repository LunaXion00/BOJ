import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = alp;
        int maxCop = cop;
        for(int[] problem: problems){
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        if(maxAlp == alp && maxCop == cop) return 0;
        int[][] dp = new int[maxAlp+2][maxCop+2];
        for(int[] entry:dp){
            Arrays.fill(entry, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        for(int i = alp; i<=maxAlp; i++){
            for(int j = cop; j<=maxCop; j++){
                // 쌩으로 1분 써서 올리는 경우.
                dp[i+1][j] = Math.min(dp[i][j]+1, dp[i+1][j]);
                dp[i][j+1] = Math.min(dp[i][j]+1, dp[i][j+1]);
                for(int[] problem: problems){
                    if(i>=problem[0] && j >= problem[1]){
                        int rewarded_alp = Math.min(i+problem[2], maxAlp);
                        int rewarded_cop = Math.min(j+problem[3], maxCop);
                        dp[rewarded_alp][rewarded_cop] = Math.min(dp[rewarded_alp][rewarded_cop], dp[i][j]+problem[4]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}