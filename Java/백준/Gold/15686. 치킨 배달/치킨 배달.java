import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static int dist = Integer.MAX_VALUE;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static boolean[] alive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) house.add(new Point(i,j));
                else if(map[i][j] == 2) chicken.add(new Point(i,j));
            }
        }
        alive = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.print(dist);
    }
    public static void dfs(int depth, int idx){
        if(depth == M) {
            check();
            return;
        }
        for(int i = idx; i<chicken.size(); i++){
            if(alive[i]) continue;
            alive[i] = true;
            dfs(depth+1, i+1);
            alive[i] = false;
        }
    }
    public static void check(){
        int sum = 0;
        for(int i = 0; i<house.size(); i++){
            Point home = house.get(i);
            int temp = Integer.MAX_VALUE;
            for(int j = 0; j<chicken.size(); j++){
                if(!alive[j]) continue;
                Point store = chicken.get(j);
                temp = Math.min(Math.abs(home.x - store.x) + Math.abs(home.y - store.y), temp);
            }
            sum += temp;
        }
        dist = Math.min(sum, dist);
    }
}
