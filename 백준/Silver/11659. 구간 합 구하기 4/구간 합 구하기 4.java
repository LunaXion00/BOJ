import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) nums[i] = Integer.parseInt(st.nextToken());
        int[] sums = new int[N+1];
        for(int i = 1; i<=N; i++){
            sums[i] = sums[i-1]+nums[i];
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(sums[b]-sums[a-1])+"\n");
        }
        bw.flush();
    }
}