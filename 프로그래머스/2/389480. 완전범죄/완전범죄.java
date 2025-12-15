import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int cnt = info.length;
        int[] dp = new int[m];
        int maxA = 0;
        for(int[] i:info){
            maxA += i[0];
        }
        for(int[] i:info){
            int a = i[0], b = i[1];
            for(int j = m-1; j>=b; j--){
                dp[j] = Math.max(dp[j], dp[j-b]+a);
            }
        }
        int answer = maxA - dp[m-1];
        return answer >= n ? -1 : answer;
    }
}