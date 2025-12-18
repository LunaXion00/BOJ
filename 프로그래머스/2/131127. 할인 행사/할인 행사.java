import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0)+1);
        }
        for(int i = 0; i<discount.length; i++){
            if(check(map, want, number)) answer++;
            map.put(discount[i], map.get(discount[i])-1);
            if(i+10 < discount.length) map.put(discount[i+10], map.getOrDefault(discount[i+10], 0)+1);
        }
        return answer;
    }
    private boolean check(HashMap<String, Integer> map, String[] want, int[] number){
        for(int i=0; i<want.length; i++){
            if(map.getOrDefault(want[i], 0)<number[i]) return false;
        }
        return true;
    }
}