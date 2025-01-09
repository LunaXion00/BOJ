import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N,L;
    static int[][] map;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<N; i++) {
            checkRow(i);
            checkCol(i);
        }
        System.out.print(ans);
    }
    public static void checkRow(int start){
        boolean use[] = new boolean[N];
        for(int i = 0; i<N-1; i++){
            int diff = map[start][i] - map[start][i+1];
            if(diff == 0) continue;
            else if (diff == 1){
                for(int j = 1; j<=L; j++){
                    if(i+j >= N) return;
                    if(map[start][i+1] != map[start][i+j]) return;
                    if(use[i+j]) return;
                    use[i+j]= true;
                }
            }
            else if(diff == -1){
                for(int j = 0; j<L; j++){
                    if(i-j < 0) return;
                    if(map[start][i] != map[start][i-j]) return;
                    if(use[i-j]) return;
                    use[i-j] = true;
                }
            }
            else return;
        }
        ans += 1;
    }
    public static void checkCol(int start){
        boolean use[] = new boolean[N];
        for(int i = 0; i<N-1; i++){
            int diff = map[i][start] - map[i+1][start];
            if(diff == 0) continue;
            else if (diff == 1){
                for(int j = 1; j<=L; j++){
                    if(i+j >= N) return;
                    if(map[i+1][start] != map[i+j][start]) return;
                    if(use[i+j]) return;
                    use[i+j]= true;
                }
            }
            else if(diff == -1){
                for(int j = 0; j<L; j++){
                    if(i-j < 0) return;
                    if(map[i][start] != map[i-j][start]) return;
                    if(use[i-j]) return;
                    use[i-j] = true;
                }
            }
            else return;
        }
        ans += 1;
    }
}
