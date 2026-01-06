import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int t = 0; t<T; t++){
            int answer = -1;
            int N = sc.nextInt(), P = sc.nextInt();
            int[] days = new int[N];
            for(int i = 0; i<N; i++) days[i] = sc.nextInt();
            int start = 0;
            for(int end = 0; end<N; end++){
                while(true) {
                    int range = days[end] - days[start] + 1;
                    int actual = end - start + 1;
                    int gap = range - actual;
                    if (gap <= P) break;
                    start++;
                }
                int range = days[end] - days[start] + 1;
                int actual = end - start + 1;
                int gap = range - actual;
                int remain = P-gap;
                int sum = range+remain;
                answer = Math.max(answer, sum);
            }
            System.out.println("#"+(t+1)+" "+answer);
        }
    }
}