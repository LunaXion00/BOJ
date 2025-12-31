import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String entire = "";
        for(int i = 0; entire.length()<t*m; i++){
            entire += Integer.toString(i, n);
        }
        for(int i = p-1; answer.length()<t; i+=m){
            answer+= entire.charAt(i);
        }
        return answer.toUpperCase();
    }
}