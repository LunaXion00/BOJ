import java.util.*;
class Solution {
    int answer = Integer.MAX_VALUE;
    ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i<wires.length;i++){
            int u = wires[i][0];
            int v = wires[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i = 0; i<wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            boolean[] visited = new boolean[n+1];
            graph[u].remove(Integer.valueOf(v));
            graph[v].remove(Integer.valueOf(u));
            int connect = dfs(1, visited);
            int diff = Math.abs(connect-(n-connect));
            answer = Math.min(answer, diff);
            graph[u].add(v);
            graph[v].add(u);
        }
        return answer;
    }
    public int dfs(int index, boolean[] visited){
        visited[index] = true;
        int cnt = 1;
        for(int next:graph[index]){
            if(visited[next]) continue;
            cnt += dfs(next, visited);
        }
        return cnt;
    }
}