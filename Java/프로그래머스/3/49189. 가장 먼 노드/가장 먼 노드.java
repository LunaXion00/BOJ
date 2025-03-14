import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        int answer = 0;
        for(int i = 0; i<=n; i++) graph.add(new ArrayList<>());
        for(int[] i : edge){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        boolean[] visited = new boolean[n+1];
        return bfs(n, visited);
    }
    static public int bfs(int n, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        q.add(new int[]{1,0});
        visited[1] = true;
        int max_depth = 0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int v = arr[0];
            int depth = arr[1];
            if(max_depth == depth) answer++;
            else if(depth > max_depth){
                max_depth = depth;
                answer = 1;
            }
            for(int i = 0; i<graph.get(v).size(); i++){
                int w = graph.get(v).get(i);
                if(!visited[w]) {
                    q.add(new int[]{w,depth+1});
                    visited[w] = true;
                }
            }
        }
        return answer;
    }
}