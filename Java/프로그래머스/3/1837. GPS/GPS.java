import java.util.*;
class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    static final int INIT = 200;
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        int[][] dp = new int[k][n+1];
        for(int i = 0; i<k;i++) Arrays.fill(dp[i], INIT);
        dp[0][gps_log[0]] = 0;
        for(int i = 0; i<=n; i++){
            edges.add(new ArrayList<>());
            edges.get(i).add(i);
        }
        for(int[] edge : edge_list){
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i<k-1; i++){
            for(int j = 1; j<=n; j++){
                if(dp[i][j] == INIT) continue;
                for(int a = 0; a<edges.get(j).size(); a++){
                    int next = edges.get(j).get(a);
                    int fix = 0;
                    if(gps_log[i+1] != next) fix++;
                    dp[i+1][next] = Math.min(dp[i+1][next], dp[i][j]+fix);
                }
            }
        }
        return dp[k-1][gps_log[k-1]] == INIT ? -1 : dp[k-1][gps_log[k-1]];
    }
}