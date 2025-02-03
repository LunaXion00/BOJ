import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] line;
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        line = new int[m];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(land[j][i] == 1 && !visited[j][i]) bfs(land, visited, j,i);
            }
        }
        answer = Arrays.stream(line).max().getAsInt();
        return answer;
    }
    public void bfs(int[][] land, boolean[][] visited, int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[x][y] = true;
        int count = 1;
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            Point tmp = q.poll();
            set.add(tmp.y);
            for(int i = 0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=n||nx<0||ny>=m||ny<0) continue;
                if(land[nx][ny] == 1 && !visited[nx][ny]){
                    q.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                    count+=1;
                }
            }
        }
        for(int i : set){
            line[i] += count;
        }
    }
}