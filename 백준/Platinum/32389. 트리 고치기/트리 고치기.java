import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static ArrayList<Integer>[] tree;
    static boolean[] fail;
    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++) tree[i] = new ArrayList<>();
        dp = new int[N+1][K+1];
        for(int i = 1; i<=N; i++) Arrays.fill(dp[i], 1);

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        //고장난 노드들 표시. true = 고장
        fail = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++) fail[Integer.parseInt(st.nextToken())] = true;

        dfs(1, 0);
        System.out.println(dp[1][K]);
    }

    public static void dfs(int cur, int parent){
        for(int next:tree[cur]){
            if(next == parent) continue;
            dfs(next, cur);
            for(int i = K; i>=0; i--)for(int j = 0; j<=i; j++) dp[cur][i] = Math.max(dp[cur][i], dp[cur][i-j]+dp[next][j]);
        }
        if(fail[cur]){
            for(int i = K; i>=1; i--) dp[cur][i] = dp[cur][i-1];
            dp[cur][0] = 0;
        }
    }
}