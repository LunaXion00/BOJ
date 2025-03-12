import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> closet = new HashMap<>();
        for(String[] clothing:clothes){
            if(closet.containsKey(clothing[1])) closet.replace(clothing[1], closet.get(clothing[1])+1);
            else closet.put(clothing[1], 1);
        }
        for(String key:closet.keySet()){
            answer *= closet.get(key)+1;
        }
        return answer-1;
    }
}