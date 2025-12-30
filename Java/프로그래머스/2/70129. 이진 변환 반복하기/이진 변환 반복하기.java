import java.util.*;
class Solution {
    public int[] solution(String s) {
        int count = 0;
        int removed = 0;
        while(!s.equals("1")){
            count++;
            int n = s.length();
            int zero = s.replaceAll("0", "").length();
            removed += (n-zero);
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
        }
        return new int[]{count, removed};
    }
}