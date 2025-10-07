import java.util.*;
class Solution {
    class Drone{
        Point p1;
        Point p2;
        int cnt;
        // 1이면 수평, 0이면 수직
        int dir;
        public Drone(Point p1, Point p2, int cnt, int dir){
            this.p1 = p1;
            this.p2 = p2;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    // [i][j]에 수평으로 오면 [i][j][1], 수직으로 오면 [i][j][0]
    static boolean[][][] visited;
    static int[][] map;
    static int len;
    public int solution(int[][] board) {
        int answer = 0;
        len = board.length;
        map = board;
        Queue<Drone> q = new LinkedList<>();
        visited = new boolean[len][len][2];
        q.add(new Drone(new Point(0, 0), new Point(0, 1), 0, 1));
        visited[0][0][1] = true;
        visited[0][1][1] = true;
        while(!q.isEmpty()){
            Drone cur = q.poll();
            if((cur.p1.x == len-1 && cur.p1.y == len-1) || 
              (cur.p2.x == len-1 && cur.p2.y == len-1)) {
                answer = cur.cnt;
                break;
            }
            // 이동
            for(int i = 0; i<4; i++){
                Point np1 = new Point(cur.p1.x+dx[i], cur.p1.y+dy[i]);
                Point np2 = new Point(cur.p2.x+dx[i], cur.p2.y+dy[i]);
                if(!check_available(np1, np2, cur.dir)) continue;
                visited[np1.x][np1.y][cur.dir] = true;
                visited[np2.x][np2.y][cur.dir] = true;
                q.offer(new Drone(np1, np2, cur.cnt+1, cur.dir));
            }
            // 회전
            if(cur.dir == 1){
                //수평 -> 수직이면 지금 있는 칸 기준 위 아래 한칸씩 벽 유무 파악
                // 위로 회전
                if(cur.p1.x-1 >=0) {
                    // p1을 축으로
                    if(board[cur.p1.x-1][cur.p1.y] == 0 && board[cur.p1.x-1][cur.p2.y] == 0 && check_available(cur.p1, new Point(cur.p1.x-1, cur.p1.y), 0)){
                        visited[cur.p1.x][cur.p1.y][0] = true;
                        visited[cur.p1.x-1][cur.p1.y][0] = true;
                        q.offer(new Drone(cur.p1, new Point(cur.p1.x-1, cur.p1.y), cur.cnt+1, 0));
                    }
                    // p2를 축으로
                    if(board[cur.p1.x-1][cur.p1.y] == 0 && board[cur.p1.x-1][cur.p2.y] == 0 && check_available(new Point(cur.p2.x-1, cur.p2.y), cur.p2, 0)){
                        visited[cur.p2.x-1][cur.p2.y][0] = true;
                        visited[cur.p2.x][cur.p2.y][0] = true;
                        q.offer(new Drone(new Point(cur.p2.x-1, cur.p2.y), cur.p2, cur.cnt+1, 0));
                    }
                }
                // 아래로 회전
                if(cur.p1.x+1 < len){
                    // p1을 축으로
                    if(board[cur.p1.x+1][cur.p1.y] == 0 && board[cur.p1.x+1][cur.p2.y] == 0 && check_available(cur.p1, new Point(cur.p1.x+1, cur.p1.y), 0)){
                        visited[cur.p1.x][cur.p1.y][0] = true;
                        visited[cur.p1.x+1][cur.p1.y][0] = true;
                        q.offer(new Drone(cur.p1, new Point(cur.p1.x+1, cur.p1.y), cur.cnt+1, 0));
                    }
                    // p2를 축으로
                    if(board[cur.p1.x+1][cur.p1.y] == 0 && board[cur.p1.x+1][cur.p2.y] == 0 && check_available(new Point(cur.p2.x+1, cur.p2.y), cur.p2, 0)){
                        visited[cur.p2.x+1][cur.p2.y][0] = true;
                        visited[cur.p2.x][cur.p2.y][0] = true;
                        q.offer(new Drone(new Point(cur.p2.x+1, cur.p2.y), cur.p2, cur.cnt+1, 0));
                    }
                }
            }
            else{
                // 수직 -> 수평이면 지금 있는 칸 기준 좌우 한칸씩 벽 유무 파악.
                // 왼쪽으로 회전
                if(cur.p1.y-1 >=0) {
                    // p1을 축으로
                    if(board[cur.p1.x][cur.p1.y-1] == 0 && board[cur.p2.x][cur.p1.y-1] == 0 && check_available(cur.p1, new Point(cur.p1.x, cur.p1.y-1), 1)){
                        visited[cur.p1.x][cur.p1.y][1] = true;
                        visited[cur.p1.x][cur.p1.y-1][1] = true;
                        q.offer(new Drone(cur.p1, new Point(cur.p1.x, cur.p1.y-1), cur.cnt+1, 1));
                    }
                    // p2를 축으로
                    if(board[cur.p1.x][cur.p1.y-1] == 0 && board[cur.p2.x][cur.p1.y-1] == 0 && check_available(new Point(cur.p2.x, cur.p2.y-1), cur.p2, 1)){
                        visited[cur.p2.x][cur.p2.y-1][1] = true;
                        visited[cur.p2.x][cur.p2.y][1] = true;
                        q.offer(new Drone(new Point(cur.p2.x, cur.p2.y-1), cur.p2, cur.cnt+1, 1));
                    }
                }
                // 오른쪽으로 회전
                if(cur.p1.y+1 < len) {
                    // p1을 축으로
                    if(board[cur.p1.x][cur.p1.y+1] == 0 && board[cur.p2.x][cur.p1.y+1] == 0 && check_available(cur.p1, new Point(cur.p1.x, cur.p1.y+1), 1)){
                        visited[cur.p1.x][cur.p1.y][1] = true;
                        visited[cur.p1.x][cur.p1.y+1][1] = true;
                        q.offer(new Drone(cur.p1, new Point(cur.p1.x, cur.p1.y+1), cur.cnt+1, 1));
                    }
                    // p2를 축으로
                    if(board[cur.p1.x][cur.p1.y+1] == 0 && board[cur.p2.x][cur.p1.y+1] == 0 && check_available(new Point(cur.p2.x, cur.p2.y+1), cur.p2, 1)){
                        visited[cur.p2.x][cur.p2.y+1][1] = true;
                        visited[cur.p2.x][cur.p2.y][1] = true;
                        q.offer(new Drone(new Point(cur.p2.x, cur.p2.y+1), cur.p2, cur.cnt+1, 1));
                    }
                }
            }
        }
        return answer;
    }
    public boolean check_available(Point p1, Point p2, int dir){
        if(p1.x >= len || p2.x >= len || p1.y >= len || p2.y >=len || 
                  p1.x < 0 || p2.x < 0 || p1.y < 0 || p2.y < 0) return false;
        if(visited[p1.x][p1.y][dir] && visited[p2.x][p2.y][dir]) return false;
        if(map[p1.x][p1.y] == 1|| map[p2.x][p2.y] == 1) return false;
        return true;
    }
}