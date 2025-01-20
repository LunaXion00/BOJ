import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int W = 0, H = 1, D = 2; // W = 가로, H = 세로, D = 대각선
    static int[][] map;
    static int[][][] bp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        bp = new int[N][N][3];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        bp[0][1][W] = 1;
        for(int i = 0; i<N; i++){
            for(int j = 1; j<N; j++){
                if(i==0 && j ==1) continue;
                if(map[i][j] == 1) continue;
                if(i-1 >=0 && map[i-1][j-1] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1) bp[i][j][D] = bp[i-1][j-1][W]+bp[i-1][j-1][H]+bp[i-1][j-1][D];
                if(i-1 >= 0 && map[i-1][j] != 1) bp[i][j][H] = bp[i-1][j][H] + bp[i-1][j][D];
                if(map[i][j-1] != 1) bp[i][j][W]= bp[i][j-1][W] + bp[i][j-1][D];
            }
        }
        System.out.print(bp[N-1][N-1][W]+bp[N-1][N-1][H]+bp[N-1][N-1][D]);
    }
}
