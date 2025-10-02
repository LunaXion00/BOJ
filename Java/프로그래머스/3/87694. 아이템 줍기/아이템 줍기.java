import java.util.*;
class Solution {
    static int[][] rects;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Node{
        int x;
        int y;
        int level;
        public Node(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        rects = rectangle;
        visited = new boolean[52][52];
        int answer = 0;
        visited[characterX][characterY] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(characterX, characterY, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x == itemX && cur.y == itemY) {
                answer = cur.level;
                break;
            }
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(!visited[nx][ny] && !check_inside(nx-dx[i]*0.5, ny-dy[i]*0.5) && check_boarder(nx-dx[i]*0.5, ny-dy[i]*0.5)){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.level+1));
                }
            }
        }
        return answer;
    }
    // 가는 경로가 어느 직사각형을 관통하는지 확인.
    public boolean check_inside(double x, double y){
        for(int[] rect: rects){
            if(rect[0] < x && rect[2] > x && rect[1] < y && rect[3] > y){
                return true;
            } 
        }
        return false;
    }
    // 테두리 위인지 확인
    public boolean check_boarder(double x, double y){
        for(int[] rect:rects){
            if((rect[0] == x && (rect[1] <=y && rect[3] >= y)) 
               || (rect[2] == x && (rect[1] <=y && rect[3] >= y))
               || (rect[1] == y && (rect[0] <=x && rect[2] >= x)) 
               || (rect[3] == y && (rect[0] <=x && rect[2] >= x))) return true;
        }
        return false;
    }
}