class Solution {
    static int[][] game;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int r, c;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        game = board;
        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];

        return minmax(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
    public int minmax(int ay, int ax, int by, int bx){
        int ret = 0;
        if(visited[ay][ax]) return 0;
        
        for(int i = 0; i<4; i++){
            int nx = ax+dx[i];
            int ny = ay+dy[i];
            if(nx >= c || ny >= r || nx < 0 || ny < 0) continue;
            if(visited[ny][nx] || game[ny][nx] == 0) continue;
            visited[ay][ax] = true;
            int avail = minmax(by, bx, ny, nx) + 1;
            visited[ay][ax] = false;
            if(ret % 2 == 0 && avail % 2 == 1) ret = avail;
            else if(ret % 2 == 0 && avail % 2 == 0) ret = Math.max(ret, avail);
            else if(ret % 2 == 1 && avail % 2 == 1) ret = Math.min(ret, avail);
        }
        return ret;
    }
}