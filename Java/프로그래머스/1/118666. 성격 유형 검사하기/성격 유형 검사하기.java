import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<survey.length; i++){
            char e1 = survey[i].charAt(0);
            char e2 = survey[i].charAt(1);
            if(choices[i] > 4) map.put(e2, map.getOrDefault(e2, 0)+choices[i]-4);
            else if(choices[i] < 4) map.put(e1, map.getOrDefault(e1, 0)+4-choices[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R':'T');
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C':'F');
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J':'M');
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A':'N');
        return sb.toString();
    }
}