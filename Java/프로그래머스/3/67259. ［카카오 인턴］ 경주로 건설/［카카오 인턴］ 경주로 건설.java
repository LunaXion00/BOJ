import java.util.*;
class Solution {
    // 0: 아래, 1 : 오른쪽, 2: 위, 3: 왼쪽
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] costs;
    static int n;
    class Car{
        int x;
        int y;
        int dir;
        int cost;
        public Car(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        n = board.length; 
        int answer = Integer.MAX_VALUE;
        costs = new int[n][n];
        costs[0][0] = 100;
        Queue<Car> q = new LinkedList<>();
        q.offer(new Car(0, 0, 0, 100));
        q.offer(new Car(0, 0, 1, 100));
        while(!q.isEmpty()){
            Car cur = q.poll();
            if(cur.x == n-1 && cur.y == n-1) {
                answer = Math.min(answer, cur.cost);
                continue;
            }
            for(int i = 0; i<4; i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx >= n || ny >= n || nx < 0 || ny < 0) continue;
                if(board[nx][ny] == 1) continue;
                int next_cost = (cur.dir == i)?100:600;
                if(costs[nx][ny] == 0){
                    costs[nx][ny] = cur.cost+next_cost;
                    q.offer(new Car(nx, ny, i, costs[nx][ny]));
                }
                else if(costs[nx][ny]+500 > cur.cost+next_cost){
                    costs[nx][ny] = cur.cost+next_cost;
                    q.offer(new Car(nx, ny, i, costs[nx][ny]));
                }
            }
        }
        return answer - 100;
    }
}