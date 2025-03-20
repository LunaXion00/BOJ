import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] num = number.toCharArray();
        int len = num.length - k;
        int start = 0;
        
        for(int i = 0; i<len; i++){
            int max = 0;
            for(int j = start; j<=i+k; j++){
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    start = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}