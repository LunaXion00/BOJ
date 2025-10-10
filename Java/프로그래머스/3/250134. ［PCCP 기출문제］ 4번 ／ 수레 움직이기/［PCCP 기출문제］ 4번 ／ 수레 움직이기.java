import java.util.*;
class Solution {
    static int[] dx = {-1,1 , 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] r_visited;
    static boolean[][] b_visited;
    static int n,m, trc, trr, tbc, tbr;
    static int answer;
    static int[][] maze;
    public int solution(int[][] maz) {
        int rr = 0;
        int rc = 0;
        int br = 0;
        int bc = 0;
        maze = maz;
        answer = Integer.MAX_VALUE;
        n = maze.length; m = maze[0].length;
        r_visited = new boolean[n][m]; b_visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(maze[i][j] == 1) {
                    rr = i; rc = j;
                } else if(maze[i][j] == 2) {
                    br = i; bc = j;
                } else if(maze[i][j] == 3) {
                    trr = i; trc = j;
                } else if(maze[i][j] == 4) {
                    tbr = i; tbc = j;
                }
            }
        }
        r_visited[rr][rc] = true;
        b_visited[br][bc] = true;
        dfs(0, rr, rc, br, bc, false, false);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void dfs(int depth, int rr, int rc, int br, int bc, boolean r_end, boolean b_end){
        if(!r_end && r_arrive(rr, rc)) r_end = true;
        if(!b_end && b_arrive(br, bc)) b_end = true;
        if(r_end && b_end) {
            answer = Math.min(answer, depth);
            return;
        }
        ArrayList<int[]> r_move = new ArrayList<>();
        ArrayList<int[]> b_move = new ArrayList<>();
        if(!r_end){
            for(int i = 0; i<4; i++){
                int nrr = dx[i] + rr;
                int nrc = dy[i] + rc;
                if(!outbound(nrr, nrc) && maze[nrr][nrc] != 5 && !r_visited[nrr][nrc]){
                    r_move.add(new int[]{nrr, nrc});
                }
            }
        } else r_move.add(new int[]{rr, rc});
        
        if(!b_end){
            for(int i = 0; i<4; i++){
                int nbr = dx[i] + br;
                int nbc = dy[i] + bc;
                if(!outbound(nbr, nbc) && maze[nbr][nbc] != 5 && !b_visited[nbr][nbc]){
                    b_move.add(new int[]{nbr, nbc});
                }
            }
        } else b_move.add(new int[]{br, bc});
        for(int i = 0; i<r_move.size(); i++){
            int[] next_r = r_move.get(i);
            for(int j = 0; j<b_move.size(); j++){
                int[] next_b = b_move.get(j);
                if(next_r[0] == next_b[0] && next_r[1] == next_b[1]) continue;
                if(next_r[0] == br && next_r[1] == bc && next_b[0] == rr && next_b[1] == rc) continue;
                r_visited[next_r[0]][next_r[1]] = true;
                b_visited[next_b[0]][next_b[1]] = true;
                dfs(depth+1, next_r[0], next_r[1], next_b[0], next_b[1], r_end, b_end);
                r_visited[next_r[0]][next_r[1]] = false;
                b_visited[next_b[0]][next_b[1]] = false;
            }
        }
    }
    public boolean outbound(int nr, int nc){
        if(nr < 0 || nc < 0 || nr >= n || nc >= m) return true;
        return false;
    }
    public boolean r_arrive(int rr, int rc){
        return rr==trr && rc == trc;
    }
    public boolean b_arrive(int br, int bc){
        return br==tbr && bc == tbc;
    }
}