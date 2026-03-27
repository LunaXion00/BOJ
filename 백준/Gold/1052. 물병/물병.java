import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = find(N, K);
        System.out.println(answer);
    }
    public static int find(int N, int K) {
        int count = 0;
        while(Integer.bitCount(N) > K) {
            N += 1;
            count += 1;
        }
        return count;
    }
}