import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for(int i = 0; i<N; i++) arr[i] = br.readLine();

        int length = Math.min(N, M);
        outer:for(; length>1; length--){
            for(int i = 0; i<N-length+1;i++) {
                for (int j = 0; j < M - length+1; j++) {
                    char now = arr[i].charAt(j);
                    char c1 = arr[i + length-1].charAt(j);
                    char c2 = arr[i].charAt(j + length-1);
                    char c3 = arr[i + length-1].charAt(j + length-1);
                    if (now == c1 && c1 == c2 && c2 == c3) break outer;
                }
            }
        }

        System.out.println(length*length);
    }
}