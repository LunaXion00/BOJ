import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 0; t < T; t++){
            int N = sc.nextInt(), P = sc.nextInt();
            long max = (long)Math.pow(N/P+1, N%P) * (long)Math.pow(N/P, P-N%P);
            System.out.println("#"+(t+1)+" "+max);
        }
    }
}
