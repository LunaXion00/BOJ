import java.util.*;
class Solution {
    static int[][] cost;
    static int[][][] dp;
    static int len;
    static String num;
    public int solution(String numbers) {
        int answer = 0;
        num = numbers;
        len = numbers.length();
        dp = new int[len+1][10][10];
        for(int i = 0; i<=len; i++) for(int j = 0; j<10; j++) Arrays.fill(dp[i][j], Integer.MAX_VALUE);
        
        cost = new int[][] {
			{1, 7, 6, 7, 5, 4, 5, 3, 2, 3}, {7, 1, 2, 4, 2, 3, 5, 4, 5, 6}, {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
			{7, 4, 2, 1, 5, 3, 2, 6, 5, 4}, {5, 2, 3, 5, 1, 2, 4, 2, 3, 5}, {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
			{5, 5, 3, 2, 4, 2, 1, 5, 3, 2}, {3, 4, 5, 6, 2, 3, 5, 1, 2, 4}, {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
			{3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
		};
        
        return getMoveCount(0, 4, 6);
    }
    public int getMoveCount(int index, int left, int right){
        if(index == len) return 0;
        if(dp[index][left][right] != Integer.MAX_VALUE) return dp[index][left][right];
        int target = num.charAt(index)-'0';
        
        int leftMove = Integer.MAX_VALUE;
        int rightMove = Integer.MAX_VALUE;
        
        if(target != right){
            leftMove = getMoveCount(index+1, target, right) + cost[left][target];
        }
        if(target != left){
            rightMove = getMoveCount(index+1, left, target) + cost[right][target];
        }
        dp[index][left][right] = Math.min(leftMove, rightMove);
        return dp[index][left][right];
    }
}