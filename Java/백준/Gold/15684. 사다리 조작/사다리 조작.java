import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H,a, b;
    static int[][] link;
    static int ans = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        link = new int[H+1][N+1];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            link[a][b] = 1;
        }
        dfs(0, 4);
        if(ans < 4) System.out.print(ans);
        else System.out.println("-1");
    }
    public static void dfs(int depth, int limit){
        if(depth == limit || depth>=ans) return;
        if(check()){
            ans = depth;
            return;
        }
        for(int i = 1; i<N; i++){
            for(int j = 1; j<=H; j++){
                // 해당 위치에 이미 선이 그어져있거나 전칸과 다음칸에 이미 선이 존재하는 경우 연속해서 그을 수 없으므로 패스.
                if(link[j][i] == 1) continue;
                if(link[j][i-1] ==1 || link[j][i+1] ==1) continue;
                if(depth+1 >=ans) return;
                link[j][i] = 1;
                dfs(depth+1, limit);
                link[j][i] = 0;
            }
        }
    }
    public static boolean check(){
        for(int i = 1; i<=N; i++){
            int c=i, r =1;
            for(; r<=H; r++){
                if(link[r][c] == 1) c += 1;
                else if(link[r][c-1] == 1) c -= 1;
            }
            if(c != i) return false;
        }
        return true;
    }
}
