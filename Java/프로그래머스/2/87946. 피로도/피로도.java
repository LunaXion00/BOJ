class Solution {
    boolean[] visited;
    int n;
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        dfs(dungeons, k, 0);
        return answer;
    }
    public void dfs(int[][] dungeons, int k, int depth){
        if(depth > n) {
            answer++;
            return;
        }
        for(int i = 0; i<n;i++){
            if(visited[i] || k<dungeons[i][0]) continue;
            visited[i] = true;
            answer = Math.max(answer, depth+1);
            dfs(dungeons, k-dungeons[i][1], depth+1);
            visited[i] = false;
        }
    }
}