import java.util.*;
class Solution {    
    static HashMap<String, List<Integer>> volunteer = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String vol: info){
            String[] information = vol.split(" ");
            int score = Integer.parseInt(information[4]);
            StringBuilder sb = new StringBuilder();
            add_volunteer(information, 0, "");
        }
        for(String key:volunteer.keySet()){
            Collections.sort(volunteer.get(key));
        }
        for(int i = 0; i<query.length; i++){
            String[] information = query[i].replaceAll(" and ", " ").trim().split("\\s+");
            String goal = information[0]+information[1]+information[2]+information[3];
            int score = Integer.parseInt(information[4]);
            answer[i] = count(goal, score);
        }
        return answer;
    }
    public void add_volunteer(String[] information, int index, String key){
        if(index == 4){
            List<Integer> list = volunteer.getOrDefault(key, new ArrayList<>());
            list.add(Integer.parseInt(information[index]));
            volunteer.put(key, list);
            return;
        }
        add_volunteer(information, index+1, key+information[index]);
        add_volunteer(information, index+1, key+"-");
    }
    public int count(String goal, int score){
        List<Integer> candidate = volunteer.getOrDefault(goal, new ArrayList<>());
        int start = 0;
        int end = candidate.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(candidate.get(mid) < score) start = mid+1;
            else end = mid-1;
        }
        return candidate.size() - start;
    }
}