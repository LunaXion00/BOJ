import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 1;
        for(char c ='A'; c<='Z'; c++){
            map.put(c+"", index++);
        }
        int str_index = 0;
        while(str_index<msg.length()){
            String w = String.valueOf(msg.charAt(str_index));
            
            while(str_index + 1 < msg.length() && 
                  map.containsKey(w + msg.charAt(str_index + 1))){
                w += msg.charAt(str_index + 1);
                str_index++;
            }

            answer.add(map.get(w));
            
            if(str_index + 1 < msg.length()){
                map.put(w + msg.charAt(str_index + 1), index++);
            }
            
            str_index++;
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}