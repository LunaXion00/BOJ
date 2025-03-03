import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i<plays.length; i++){
            if(!total.containsKey(genres[i])){
                HashMap<Integer,Integer> entry = new HashMap<>();
                entry.put(i, plays[i]);
                map.put(genres[i], entry);
                total.put(genres[i], plays[i]);
            }
            else{
                map.get(genres[i]).put(i, plays[i]);
                total.put(genres[i], total.get(genres[i])+plays[i]);
            }
        }
        List<String> keySet = new ArrayList(total.keySet());
        Collections.sort(keySet, (s1, s2)->total.get(s2)-total.get(s1));
        for(String key : keySet){
            HashMap<Integer, Integer> entry = map.get(key);
            List<Integer> entryKey = new ArrayList(entry.keySet());
            
            Collections.sort(entryKey, (s1, s2)-> entry.get(s2)- entry.get(s1));
            answer.add(entryKey.get(0));
            if(entryKey.size()>1) answer.add(entryKey.get(1));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}