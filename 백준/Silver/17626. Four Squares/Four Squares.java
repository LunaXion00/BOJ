import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        Arrays.fill(dp, 5);
        for(int i = 1; i<=Math.sqrt(N); i++) dp[i*i] = 1;
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=Math.sqrt(i); j++){
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}