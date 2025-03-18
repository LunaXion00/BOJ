import java.util.*;
import java.util.Map.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> id = Arrays.asList(id_list);
        HashMap<String, HashMap<String, Integer>> log = new HashMap<>();
        
        for(String entry:report){
            String[] ids = entry.split(" ");
            HashMap<String, Integer> map = log.getOrDefault(ids[1], new HashMap<String, Integer>());
            map.put(ids[0], 0);
            log.put(ids[1], map);
        }
        for(Entry<String, HashMap<String, Integer>> entry: log.entrySet()){
            if(entry.getValue().size()>=k){
                for(String v: entry.getValue().keySet()){
                    answer[id.indexOf(v)] += 1;
                }
            }
        }
        return answer;
    }
}