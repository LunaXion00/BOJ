import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[] board;
    static int sx, sy, ex, ey, lx, ly;
    public int solution(String[] maps) {
        board = maps;
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                }
                else if(maps[i].charAt(j) == 'E'){
                    ex = i;
                    ey = j;
                }
                else if(maps[i].charAt(j)=='L'){
                    lx = i;
                    ly = j;
                }
            }
        }
        int toLever = pathFinder(sx, sy, lx, ly);
        int toExit = pathFinder(lx, ly, ex, ey);
        if(toLever == -1 || toExit == -1) return -1;
        else return toLever+toExit;
    }
    private int pathFinder(int sx, int sy, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == ex && cur[1] == ey) return cur[2];
            for(int i = 0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(!inRange(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(board[nx].charAt(ny) == 'X') continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2]+1});
            }        
        }
        return -1;
    }
    private boolean inRange(int x, int y){
        if(x >= board.length || x < 0 || y >= board[0].length() || y < 0) return false;
        return true;
    }
}