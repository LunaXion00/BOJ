import java.util.*;
class Solution {
    ArrayList<String> route = new ArrayList<>();
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(route);
        return route.get(0).split(" ");
    }
    public void dfs(int depth, String now, String path, String[][] tickets){
        if(depth == tickets.length) {
            route.add(path);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(visited[i]) continue;
            if(now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth+1, tickets[i][1], path+" "+tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}