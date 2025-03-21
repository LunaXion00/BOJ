import java.util.*;
class Solution {
    int N;
    int[][] graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        N = n;
        graph = new int[N+1][N+1];
        for(int[] fare: fares){
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            graph[u][v] = cost;
            graph[v][u] = cost;
        }
        int[] start = dijkstra(s);
        for(int i = 1; i<=n; i++){
            int[] alone = dijkstra(i);
            int cost = start[i] + alone[a] + alone[b];
            if(cost<answer) answer = cost;
        }
        return answer;
    }
    public int[] dijkstra(int start){
        int[] costs = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[0]));
        costs[start] = 0;
        pq.add(new int[]{0, start});
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            if(visited[current[1]]) continue;
            visited[current[1]] = true;
            for(int i = 1; i<=N; i++){
                if(graph[i][current[1]] == 0) continue;
                if(graph[i][current[1]] + costs[current[1]] < costs[i]){
                    costs[i] = graph[i][current[1]] + costs[current[1]];
                    pq.add(new int[]{costs[i], i});
                }
            }
        }
        return costs;
    }
}