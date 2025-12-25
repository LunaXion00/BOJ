import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char last = words[0].charAt(0);
        for(int i = 0; i<words.length; i++){
            if(set.contains(words[i]) || last != words[i].charAt(0)) return new int[]{i%n+1, i/n+1};
            else {
                set.add(words[i]);
                last = words[i].charAt(words[i].length()-1);
            }
        }
        return new int[]{0, 0};
    }
}