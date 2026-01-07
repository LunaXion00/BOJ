import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int div = 1234567891;
        for(int t = 0; t<T; t++){
            int N = sc.nextInt();
            long[][] dp = new long[N][21];
            int[] nums = new int[N];
            for(int i = 0; i<N; i++) nums[i] = sc.nextInt();
            dp[0][nums[0]] = 1;
            
            for(int i = 0; i<N-2; i++) {
                for(int j = 0; j<=20; j++){
                    if(dp[i][j] == 0) continue;
                    int plus = j+nums[i+1];
                    if(plus >= 0 && plus <= 20) dp[i+1][plus] = (dp[i+1][plus]+dp[i][j])%div;
                    int minus = j-nums[i+1];
                    if(minus >= 0 && minus <= 20) dp[i+1][minus] = (dp[i+1][minus]+dp[i][j])%div;
                }
            }
            System.out.println("#"+(t+1)+" "+dp[N-2][nums[N-1]]%div);
        }
    }
}