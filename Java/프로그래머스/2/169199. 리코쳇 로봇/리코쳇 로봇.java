import java.util.*;

class Point{
    int x;
    int y;
    int index;
    public Point(int x, int y, int index){
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, m;
    static 
    public int solution(String[] board) {
        int answer = -1;
        n = board.length;
        m = board[0].length();
        Queue<Point> q = new ArrayDeque();
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i].charAt(j) == 'R'){
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
            if(!q.isEmpty()) break;
        }
        while(!q.isEmpty()){
            Point current = q.poll();
            if(board[current.x].charAt(current.y)=='G') return current.index;
            for(int i = 0; i<4; i++){
                int nx = current.x;
                int ny = current.y;
                while(true){
                    if(check(nx, ny) && board[nx].charAt(ny) !='D'){
                        nx += dx[i];
                        ny += dy[i];
                    }
                    else{
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny, current.index + 1));
            }
        }
        return answer;
    }
    static public boolean check(int x, int y){
        if(x >= n || y >= m || x < 0 || y < 0) return false;
        return true;
    }
}