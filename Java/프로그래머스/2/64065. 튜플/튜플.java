import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s= s.substring(2, s.length()-2);
        String[] entry = s.split("\\},\\{");
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: entry){
            String[] a = str.split(",");
            for(String num:a){
                map.put(num, map.getOrDefault(num, 0)+1);
            }
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2)-> map.get(s2)-map.get(s1));
        answer = new int[keyList.size()];
        for(int i = 0; i<keyList.size(); i++){
            answer[i] = Integer.parseInt(keyList.get(i));
        }
        return answer;
    }
}