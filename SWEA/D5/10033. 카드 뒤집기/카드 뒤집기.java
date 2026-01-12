import java.util.Scanner;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int t = 1; t <= T; t++) {
            String cards = sc.next();
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