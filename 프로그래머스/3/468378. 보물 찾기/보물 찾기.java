import java.util.function.Function;
import java.util.*;
class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        // cost[i][j]는 i~j 사이에 보물이 있다고 상정했을 때 최소 비용
        // pick[i][j]는 i~j 사이에 보물이 있다고 상정했을 때, 어디를 파야 cost[i][j]가 나오는지.
        int[][] cost = new int[n+2][n+2];
        int[][] pick = new int[n+2][n+2];
        for(int length = 1; length < n+1; length++){
            for(int i = 1; i<=n-length+1; i++){
                int j = i+length-1;
                if(i == j){
                    cost[i][j] = depth[i-1];
                    pick[i][j] = i;
                    continue;
                }
                int c = Integer.MAX_VALUE;
                int best_point = i;
                for(int k = i; k<j+1; k++){
                    int expect = depth[k-1] + Math.max(cost[i][k-1], cost[k+1][j]);
                    if(expect < c){
                        c = expect;
                        best_point = k;
                    }
                }
                cost[i][j] = c;
                pick[i][j] = best_point;
            }
        }
        int left = 1, right = n;
        while(left <= right){
            int mid = pick[left][right];
            int result = excavate.apply(mid);
            if(result == 0) return mid;
            else if (result == 1) left = mid+1;
            else right = mid-1;
        }
        return 0;
    }
}