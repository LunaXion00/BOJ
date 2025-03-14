import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int type = new HashSet<>(Arrays.asList(gems)).size();
        int left = 0, right = 0;
        int start = 0, end = 0;
        int distance = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        while(true){
            if(map.size() == type){
                map.put(gems[left], map.get(gems[left])-1);
                if(map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            }else if(right == gems.length){
                break;
            } else{
                map.put(gems[right], map.getOrDefault(gems[right], 0)+1);
                right++;
            }
            if(map.size() == type){
                if(distance > right-left){
                    distance = right-left;
                    end = right;
                    start = left+1;
                }
            }
        }
        return new int[]{start, end};
    }
}