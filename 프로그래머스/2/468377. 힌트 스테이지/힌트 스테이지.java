import java.util.*;
class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length;
        // 각 스테이지 당 힌트를 사는 경우를 비트로 표현. 0000...이면 모든 스테이지에서 힌트를 안사는 경우.
        for(int i = 0; i<(1 << (n-1)); i++){
            int[] ticket = new int[n+1];
            int total = 0;
            for(int j = 1; j<= n;j++){
                total += cost[j - 1][ticket[j]];
                if(j<n && (i & 1<<(j-1)) != 0) {
                    total += hint[j-1][0];
                    for(int k = 1; k<hint[j-1].length; k++) if(ticket[hint[j-1][k]] < n-1) ticket[hint[j-1][k]]++;
                }
            }
            answer = Math.min(answer, total);
        }
        return answer;
    }
}