import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mod = 1000000007;
        long answer = 0;

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        long[] cycle = new long[N+1];
        for(int i = 1; i<=N; i++){
            for(int j : graph[i]) for(int k:graph[j]) if(k != i) answer += cycle[k]++;
            for(int j : graph[i]) for(int k : graph[j]) cycle[k] = 0;
        }
        System.out.println(answer /4 %mod);
    }
}