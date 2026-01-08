import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            if(N==1) sb.append("0");
            else{
                if(N % 2 == 1) sb.append("4");
                for(int i = 0; i<N/2; i++) sb.append("8");
            }
            System.out.println(sb.toString());
        }
    }
}
