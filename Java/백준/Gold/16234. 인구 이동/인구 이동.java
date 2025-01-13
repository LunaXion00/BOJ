import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,L,R;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        while(true){
            boolean keep = false;
            boolean[][] isvisited = new boolean[N][N];
            for(int i = 0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(!isvisited[i][j]) {
                        boolean moved = bfs(isvisited, i, j);
                        if(moved) keep = true;
                    }
                }
            }
            if(!keep) break;
            ans++;
        }
        System.out.print(ans);
    }
    static public boolean bfs(boolean[][] isvisited, int x, int y){
        Queue<Point> q = new LinkedList<>();
        Queue<Point> alli = new LinkedList<>();
        isvisited[x][y] = true;
        q.add(new Point(x, y));
        alli.add(new Point(x,y));

        int cnt = 1;
        int sum = map[x][y];
        while(!q.isEmpty()){
            Point point = q.poll();
            for(int i = 0; i<4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx >=N || ny >= N || nx <0 || ny < 0) continue;
                if(isvisited[nx][ny]) continue;
                if(Math.abs(map[nx][ny] - map[point.x][point.y]) >= L && Math.abs(map[nx][ny] - map[point.x][point.y]) <= R){
                    isvisited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    alli.add(new Point(nx, ny));
                    sum += map[nx][ny];
                    cnt += 1;
                }
            }
        }
        if(cnt == 1) return false;
        else{
            while(!alli.isEmpty()){
                Point point = alli.poll();
                map[point.x][point.y] = sum/cnt;
            }
            return true;
        }
    }
}
