class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            dfs(computers, i, visited);
            answer++;
        }
        return answer;
    }
    public static void dfs(int[][] computers, int index, boolean[] visited){
        visited[index] = true;
        for(int i = 0 ; i<computers.length; i++){
            if(i!=index && !visited[i] && computers[index][i]==1) dfs(computers, i, visited);
        }
    }
}