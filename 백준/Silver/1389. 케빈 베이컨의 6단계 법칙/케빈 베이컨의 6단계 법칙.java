import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
class Main {
    static int INF = 6000;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];
        for(int i = 1; i<=N; i++) Arrays.fill(graph[i], INF);
        for(int i = 1; i<=N; i++) graph[i][i] = 0;

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        for(int k = 1; k<=N; k++){
            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++) graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
            }
        }
        int min = INF;
        int num = 0;
        int[] kevin = new int[N+1];
        for(int i = 1; i<=N; i++){
            int sum = 0;
            for(int j = 1; j<=N; j++){
                if(i==j) continue;
                sum += graph[i][j];
            }
            kevin[i] = sum;
        }
        for(int i = 1; i<=N; i++){
            if(kevin[i] < min) {
                min = kevin[i];
                num = i;
            }
        }
        System.out.println(num);
    }
}