import java.util.*;
class Solution {
    public class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    int cnt = 1;
                    numberOfArea++;
                    int color = picture[i][j];
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Node now = q.poll();
                        for(int a = 0; a<4; a++){
                            int nx = now.x+dx[a];
                            int ny = now.y+dy[a];
                            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                            if(visited[nx][ny]) continue;
                            if(color == picture[nx][ny]) {
                                cnt++;
                                q.offer(new Node(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}