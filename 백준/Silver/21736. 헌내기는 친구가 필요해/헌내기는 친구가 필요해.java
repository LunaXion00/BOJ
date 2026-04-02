import java.io.*;
import java.util.*;
class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M =  Integer.parseInt(st.nextToken());
        String[] campus = new String[N];
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        Point now = new Point(0, 0);
        for(int i = 0; i<N; i++) campus[i] = br.readLine();
        outer:for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++) {
                if (campus[i].charAt(j) == 'I') {
                    now = new Point(i, j);
                    break outer;
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(now);
        visited[now.x][now.y] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] || campus[nx].charAt(ny) == 'X') continue;
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
                if(campus[nx].charAt(ny) == 'P') count++;
            }
        }
        if(count == 0) System.out.print("TT");
        else System.out.println(count);
    }
}