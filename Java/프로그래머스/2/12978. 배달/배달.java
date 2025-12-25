import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                if(i==j) continue;
                graph[i][j] = 1234567;
            }
        }
        for(int[] v:road){
            int a = v[0];
            int b = v[1];
            int w = v[2];
            if(graph[a][b] > w){
                graph[a][b] = w;
                graph[b][a] = w;
            }
        }
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                for(int k = 1; k<=N; k++){
                    if(graph[j][k] > graph[j][i]+graph[i][k]){
                        graph[j][k] = graph[j][i]+graph[i][k];
                    }
                }
            }
        }
        for(int i = 1; i<=N; i++){
            if(graph[1][i] <= K) answer++;
        }
        return answer;
    }
}