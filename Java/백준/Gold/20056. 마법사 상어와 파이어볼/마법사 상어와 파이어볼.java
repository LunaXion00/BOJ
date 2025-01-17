import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static ArrayList<Fire>[][] map;
    static class Fire{
        int x;
        int y;
        int m;
        int dir;
        int s;
        public Fire(int x, int y, int m, int dir, int s){
            this.x = x;
            this.y = y;
            this.m = m;
            this.dir = dir;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken()) -1;
            int y= Integer.parseInt(st.nextToken()) -1;
            int m= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int dir= Integer.parseInt(st.nextToken());
            Fire fire = new Fire(x,y,m,dir,s);
            if(map[x][y] == null){
                map[x][y] = new ArrayList<Fire>();
                map[x][y].add(fire);
            }
            else map[x][y].add(fire);
        }
        while(K-->0){
            ArrayList<Fire>[][] temp = new ArrayList[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(map[i][j] == null) continue;
                    for(int p = 0; p<map[i][j].size(); p++){
                        Fire fire = map[i][j].get(p);
                        int nx = fire.x+dx[fire.dir]*(fire.s%N);
                        int ny = fire.y+dy[fire.dir]*(fire.s%N);
                        if(nx <0) nx = N-Math.abs(nx);
                        else if(nx >=N) nx -=N;
                        if(ny <0) ny = N-Math.abs(ny);
                        else if(ny>=N) ny -= N;

                        if(temp[nx][ny] == null) temp[nx][ny] = new ArrayList<>();
                        temp[nx][ny].add(new Fire(nx,ny, fire.m, fire.dir, fire.s));
                    }
                }
            }
            for(int i = 0; i<N;i++){
                for(int j = 0; j<N; j++){
                    if(temp[i][j] == null || temp[i][j].size() == 1) continue;
                    int sum_m = 0;
                    int sum_s = 0;
                    int size = temp[i][j].size();
                    boolean odd = true;
                    boolean even = true;
                    for(int p= 0; p<temp[i][j].size();p++){
                        Fire fire = temp[i][j].get(p);
                        sum_m += fire.m;
                        sum_s += fire.s;
                        if(fire.dir % 2 == 1) even = false;
                        else odd = false;
                    }
                    temp[i][j].clear();
                    if(sum_m/5 != 0){
                        for(int p = 0; p<4; p++){
                            int dir = 0;
                            if(odd||even) dir = p*2;
                            else dir = p*2+1;
                            temp[i][j].add(new Fire(i,j,sum_m/5, dir, sum_s/size));
                        }
                    }
                }
            }
            map = temp;
        }
        int ans = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N;j++){
                if(map[i][j] == null) continue;
                for(int p =0; p<map[i][j].size(); p++) ans += map[i][j].get(p).m;
            }
        }
        System.out.print(ans);
    }
}
