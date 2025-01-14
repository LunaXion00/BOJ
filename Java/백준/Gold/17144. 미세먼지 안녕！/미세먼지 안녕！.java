import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T;
    static int[][] map;
    static int ac1, ac2;
    static boolean second;
    static int[] dx = {-1,1,0,0}; // 반시계 방향은 0->3->1->2
    static int[] dy = {0,0,-1,1}; // 시계 방향은  1->2->0->3
    static int[] cw = {1,3,0,2};
    static int[] ccw = {0,3,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for(int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<C; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == -1 && second) ac2 = i;
                else if(num == -1) {
                    ac1 = i;
                    second = true;
                }
            }
        }
        while(T-->0){
            spread();
            clear();
        }
        int sum = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void spread(){
        int[][] temp = new int[R][C];
        for(int i =0; i<R; i++) temp[i] = map[i].clone();
        for(int i= 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(map[i][j] == 0 || map[i][j] == -1) continue;
                int cnt = 0;
                for(int k = 0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx<0 || ny < 0 || nx >=R || ny >=C) continue;
                    if(map[nx][ny] == -1) continue;
                    cnt++;
                    temp[nx][ny] += map[i][j]/5;
                }
                temp[i][j] -= map[i][j]/5 * cnt;
            }
        }
        for(int i = 0; i<R; i++) map[i] = temp[i].clone();
    }
    public static void clear(){
        int x = ac1, y = 0;
        for(int d = 0; d<4; d++) {
            while (true) {
                int nx = x + dx[ccw[d]];
                int ny = y + dy[ccw[d]];
                if (nx < 0 || ny < 0 || nx >= ac2 || ny >= C) break;
                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
            }
        }
        map[ac1][0] = 0;
        map[ac1][1] = 0;
        x = ac2;
        y = 0;
        for(int d = 0; d<4; d++){
            while(true){
                int nx = x+dx[cw[d]];
                int ny = y+dy[cw[d]];
                if(nx<ac2 || ny < 0 || nx >=R || ny >= C) break;
                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
            }
        }
        map[ac2][0] = 0;
        map[ac2][1] = 0;
    }
}
