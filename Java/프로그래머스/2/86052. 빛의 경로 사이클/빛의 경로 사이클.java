import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[] board;
    static int n, m;
    static boolean[][][] visited;
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        board = grid;
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                for(int k = 0; k<4; k++){
                    if(!visited[i][j][k]) answer.add(simulate(i, j, k));
                }
            }
        }
        return answer.stream().sorted().mapToInt(x->x).toArray();
    }
    private int simulate(int x, int y, int d){
        int count = 0;
        while(true){
            if(visited[x][y][d]) break;
            count++;
            visited[x][y][d] = true;
            if(board[x].charAt(y)== 'L') d = (d+3)%4;
            else if(board[x].charAt(y) == 'R') d = (d+5)%4;
            x = (x + dx[d] + n) % n;
            y = (y+ dy[d] + m) % m;
        }
        return count;
    }
}