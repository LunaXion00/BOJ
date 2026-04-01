import java.util.*;
class Solution {
    static int[][] board;
    static int N, M, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(String[] storage, String[] requests) {
        answer = 0;
        N = storage.length;
        M = storage[0].length();
        
        // (n+2)*(m+2) 크기로 보드를 생성. 테투리로 외부 공간을 한 줄씩 둘렀다고 침. 배열은 숫자로.
        board = new int[N+2][M+2];
        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=M; j++) {
                board[i][j] = storage[i-1].charAt(j-1) - 'A'+1;    
                answer++;
            }
        }
        for(String request : requests){
            System.out.println(request.charAt(0) - 'A'+1);
            if(request.length() == 2) crane(request.charAt(0) - 'A'+1);
            else lift(request.charAt(0)-'A'+1);            
        }
        return answer;
    }
    private void crane(int target){
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++) {
                if(board[i][j] == target) {
                    board[i][j] = 0;
                    answer--;
                }
            }
        }
    }
    private void lift(int target){
        Queue<Point> q = new LinkedList<>();
        Set<Point> set = new HashSet<>();
        boolean[][] visited = new boolean[N+2][M+2];
        q.add(new Point(0, 0));
        visited[0][0] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i<4; i++) {
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= N+2 || ny >= M+2) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(board[nx][ny] == 0) q.add(new Point(nx, ny));
                
                if(board[nx][ny] == target) set.add(new Point(nx, ny));
            }
        }
        for(Point p : set){
            board[p.x][p.y] = 0;
            answer--;
        }
    }
}