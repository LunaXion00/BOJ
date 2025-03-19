import java.util.*;
class Solution {
    int N;
    int E;
    int[][] matrix;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        E = fares.length;
        matrix = new int[N+1][N+1];
        
        for(int i = 0; i<E; i++){
            int u = fares[i][0];
            int v = fares[i][1];
            matrix[u][v] = fares[i][2];
            matrix[v][u] = fares[i][2];
        }
        int[] together = dijkstra(s);
        int min_cost = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++){
            int[] alone = dijkstra(i);
            int cost = alone[a]+alone[b]+together[i];
            if(cost<min_cost) min_cost = cost;
        }
        return min_cost;
    }
    public int[] dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[0]));
        boolean[] visited = new boolean[N+1];
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        pq.add(new int[]{0, start});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[1];
            if(visited[u]) continue;
            visited[u] = true;
            for(int v = 1; v<=N; v++){
                if(matrix[u][v] == 0) continue;
                if(cost[u]+matrix[u][v] < cost[v]){
                    cost[v] = cost[u]+matrix[u][v];
                    pq.add(new int[]{cost[v], v});
                }
            }
        }
        return cost;
    }
}