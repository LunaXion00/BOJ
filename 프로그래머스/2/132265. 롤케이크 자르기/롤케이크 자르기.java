import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        for(int i : topping){
            right.put(i, right.getOrDefault(i, 0)+1);
        }
        for(int i : topping){
            left.put(i, left.getOrDefault(i, 0)+1);
            int cur = right.get(i)-1;
            if(cur == 0) right.remove(i);
            else right.put(i, cur);
            if(left.size()== right.size()) answer++;
        }
        return answer;
    }
}