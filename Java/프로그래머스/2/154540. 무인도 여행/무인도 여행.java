import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int day = 0;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0;j<m; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    day += maps[i].charAt(j)-'0';
                    bfs(i, j, maps, visited);
                    num.add(day);
                    day = 0;
                }
            }
        }
        if(num.isEmpty()){
            return new int[]{-1};
        }
        Collections.sort(num);
        int[] answer = new int[num.size()];

        for(int i = 0; i<answer.length; i++){
            answer[i] = num.get(i);
        }
        return answer;
    }
    static void bfs(int x, int y, String[] maps, boolean[][] visited){
        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=n || ny >= m || nx<0 || ny < 0) continue;
            if(visited[nx][ny]) continue;
            if(maps[nx].charAt(ny) != 'X'){
                day += maps[nx].charAt(ny)-'0';
                visited[nx][ny] = true;
                bfs(nx, ny, maps, visited);
            }
        }
    }
}