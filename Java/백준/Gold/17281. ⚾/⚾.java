import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] lineup;
    static int ans = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][9];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<9; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        lineup = new int[9];
        visited = new boolean[9];
        lineup[3] = 0;
        visited[3] = true;
        build_lineup(1);
        System.out.print(ans);
    }
    public static void build_lineup(int cnt){
        if(cnt == 9) {
            simulate();
            return;
        }
        for(int i = 0; i<9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            lineup[i] = cnt;
            build_lineup(cnt+1);
            visited[i] = false;
        }
    }
    public static void simulate(){
        int score = 0;
        int start = 0;
        boolean[] base;
        for(int i = 0; i<N; i++){
            int out_cnt = 0;
            base = new boolean[4];
            while(out_cnt<3){
                int hit = board[i][lineup[start]];
                if(hit == 0) out_cnt++;
                else if(hit == 1){
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                            if(k==3){
                                score++;
                                base[k] = false;
                                continue;
                            }
                            base[k+1] = true;
                            base[k] = false;
                        }
                    }
                    base[1] = true;
                }
                else if(hit == 2){
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                            if(k==3 || k == 2) {
                                score++;
                                base[k] = false;
                                continue;
                            }
                            base[k+2] = true;
                            base[k] = false;
                        }
                    }
                    base[2] = true;
                }
                else if(hit == 3 || hit == 4){
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                                score++;
                                base[k] = false;
                        }
                    }
                    if(hit == 3) base[3] = true;
                    else score++;
                }
                start = (start+1)%9;
            }

        }
        ans = Math.max(ans, score);
    }
}