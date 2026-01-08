import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 0; t < T; t++){
            long N = sc.nextLong();
            long count = 0;
            while(N != 2) {
                long sqrt = (long)Math.sqrt(N);
                if(sqrt * sqrt == N) {
                    count++;
                    N = sqrt;
                }
                else{
                    count += (sqrt+1)*(sqrt+1) -N+ 1;
                    N = sqrt+1;
                }
            }
            System.out.println("#"+(t+1)+" "+count);
        }
    }
}
