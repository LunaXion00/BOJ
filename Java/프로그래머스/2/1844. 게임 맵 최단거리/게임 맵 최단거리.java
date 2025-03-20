import java.util.*;
class Solution {
    class Point{
        int x;
        int y;
        int depth;
        public Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        Point current = new Point(0,0,1);
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(current);
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x==n-1 && now.y == m-1) return now.depth;
            for(int i = 0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx>=n || ny >= m || nx < 0 || ny < 0) continue;
                if(visited[nx][ny] || maps[nx][ny]==0) continue;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny, now.depth+1));
            }
        }
        return -1;
    }
}