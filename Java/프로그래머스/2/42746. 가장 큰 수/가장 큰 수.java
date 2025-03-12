import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++) strings[i] = numbers[i]+"";
        
        Arrays.sort(strings, (n1, n2)->(n2+n1).compareTo(n1+n2));
        
        if (strings[0].equals("0")) {
           return "0";
        }
        
        for(int i = 0; i<strings.length; i++) sb.append(strings[i]);
        return sb.toString();
    }
}