import java.util.*;
class Solution {
    int[] cost;
    List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new List[n+1];
        for(int i = 0; i<=n; i++)graph[i] = new ArrayList<>();
        for(int[] node:roads){
            graph[node[0]].add(node[1]);
            graph[node[1]].add(node[0]);
        }
        cost = new int[n+1];
        Arrays.fill(cost, -1);
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);
        cost[destination] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i<graph[now].size(); i++){
                int next = graph[now].get(i);
                if(cost[next] == -1) {
                    cost[next] = cost[now]+1;
                    q.add(next);
                }
            }
        }
        for(int i = 0; i<sources.length;i++){
            answer[i] = cost[sources[i]];
        }
        return answer;
    }
}