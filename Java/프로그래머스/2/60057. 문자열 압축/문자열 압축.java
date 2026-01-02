import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i<=s.length()/2+1; i++){
            answer = Math.min(answer, calc(s, i));
        }
        return answer;
    }
    private int calc(String s, int div){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 1;
        while(index < s.length()){
            int endIndex = Math.min(index + div, s.length());
            String cur = s.substring(index, endIndex);
            if(index+div < s.length()){
                int nextEndIndex = Math.min(index + div * 2, s.length());
                String next = s.substring(index + div, nextEndIndex);
                if(cur.equals(next) && cur.length() == div) {
                    count++;
                } else {
                    if(count == 1) sb.append(cur);
                    else sb.append(count).append(cur);
                    count = 1;
                }
            } else {
                // 마지막 부분 처리
                if(count == 1) sb.append(cur);
                else sb.append(count).append(cur);
            }
            index += div;
        }
        return sb.toString().length();
    }
}