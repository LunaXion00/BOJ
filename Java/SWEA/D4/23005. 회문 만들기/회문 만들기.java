import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int i = 0; i<T; i++){
            String s = sc.next();
            int count = 0;
            int start = 0, end = s.length()-1;
            while(start <= end){
                if(s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                }
                else{
                    if(s.charAt(start) != 'x' && s.charAt(end) != 'x') {
                        count = -1;
                        break;
                    }
                    else{
                        count++;
                        if(s.charAt(start) == 'x') start++;
                        else end--;
                    }
                }
            }
            System.out.println(count);
        }
    }
}