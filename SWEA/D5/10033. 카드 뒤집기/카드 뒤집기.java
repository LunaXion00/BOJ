import java.util.Scanner;
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= T; t++) {
            String cards = br.readLine();
            int N = cards.length();
            long count = 0;
            int index = N;
            long w = 0;
            while(index-- > 0){
                if(cards.charAt(index) == 'W'){
                    w++;
                    continue;
                }
                if(cards.charAt(index) == 'B'){
                    long b = 1;
                    while(true){
                        if(index > 0 && cards.charAt(index-1) == 'B'){
                            b++;
                            index--;
                        }
                        else break;
                    }
                    count += w*b;
                }
            }
            System.out.println("#"+t+" "+count);
        }
    }
}