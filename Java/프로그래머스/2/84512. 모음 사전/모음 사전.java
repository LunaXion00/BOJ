import java.util.*;
class Solution {
    int answer;
    int cnt = 0;
    public int solution(String word) {
        answer = 0;
        dfs(new StringBuilder(), word);
        return answer;
    }
    public boolean dfs(StringBuilder sb, String word){
        if(sb.toString().equals(word)) return true;
        if(sb.length()>=5) return false;
        for(char c:"AEIOU".toCharArray()){
            sb.append(c);
            cnt++;
            if(dfs(sb, word)){
                answer = cnt;
                return true;
            }
            sb.deleteCharAt(sb.length() -1);
        }
        return false;
    }
}