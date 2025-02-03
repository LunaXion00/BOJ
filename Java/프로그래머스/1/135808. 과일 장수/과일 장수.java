import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int ans = 0;
        int index = score.length-1;
        for(int i = 0; i<score.length/m; i++){
            int low = Integer.MAX_VALUE;
            for(int j = 0; j<m; j++){
                low = Math.min(low, score[index--]);
            }
            ans += low*m;
        }
        return ans;
    }
}