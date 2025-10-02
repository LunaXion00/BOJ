import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer;
    static int[] sw;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        sw = info;
        for(int i = 0; i<info.length; i++) graph.add(new ArrayList<>());
    
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[info.length];
        
        dfs(0, 0, 0, visited);
        return answer;
    }
    public void dfs(int index, int sheep, int wolf, boolean[] visited){
        if(sw[index] == 0){
            sheep++;
        } else{
            wolf++;
        }
        if(wolf >= sheep) return;
        boolean[] newVisited = visited.clone();
        newVisited[index] = true;
        answer = Math.max(answer, sheep);
        for(int i =0; i<graph.size(); i++){
            if(newVisited[i]) {
                for(int x : graph.get(i)){
                    if(!newVisited[x]) dfs(x, sheep, wolf, newVisited);
                }
            }
        }
        visited[index] = false;
    }
}