import java.util.*;
class Solution {
    public String solution(String s) {
        ArrayList<Integer> num = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            num.add(Integer.parseInt(st.nextToken()));
        }
        return ""+Collections.min(num)+" "+Collections.max(num);
    }
}