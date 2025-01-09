import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int[][][] mode = {{{0}},
            {{0}, {1}, {2}, {3}},                           // 1번 CCTV
            {{2, 3}, {0, 1}},                               // 2번 CCTV
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},               // 3번 CCTV
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},   // 4번 CCTV
            {{0, 1, 2, 3}}};                                // 5번 CCTV
    public static ArrayList<Node> cctv;
    public static class Node{
        int x;
        int y;
        int type;
        public Node(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cctv = new ArrayList<>();
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(1<= map[i][j] && map[i][j] <= 5){
                    cctv.add(new Node(i, j, map[i][j]));
                }
            }
        }
        dfs(0, cctv.size(), map);
        System.out.print(ans);
    }
    public static void dfs(int idx, int N, int[][] map){
        if(idx == N){
            int cnt = check(map);
            ans = Math.min(cnt, ans);
            return;
        }
        int x = cctv.get(idx).x;
        int y = cctv.get(idx).y;
        int type = cctv.get(idx).type;
        for(int i = 0; i<mode[type].length; i++){
            int[][] copy = new int[n][m];
            for(int j = 0; j<n; j++) copy[j] = map[j].clone();
            for(int j = 0; j<mode[type][i].length; j++){
                int dir = mode[type][i][j];
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while(true){
                    if(nx < 0 || ny < 0 || nx >=n || ny >= m) break;
                    if(map[nx][ny] == 6) break;
                    copy[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
            dfs(idx+1, N, copy);
        }
    }
    public static int check(int[][] map){
        int cnt = 0;
        for(int i = 0 ; i<n; i++){
            for(int j = 0; j<m; j++) if(map[i][j] == 0) cnt++;
        }
        return cnt;
    }
}
