import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<terms.length; i++){
            map.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }
        String[] today_split = today.split("\\.");
        int today_year = Integer.parseInt(today_split[0]);
        int today_month = Integer.parseInt(today_split[1]);
        int today_date = Integer.parseInt(today_split[2]);
        int trans_today = today_year*28*12 + today_month*28 + today_date;
        for(int i = 0; i<privacies.length; i++){
            String[] day = privacies[i].split(" ")[0].split("\\.");
            String term = privacies[i].split(" ")[1];
            
            int year = Integer.parseInt(day[0]);
            int month = Integer.parseInt(day[1]) + map.get(term);
            int date = Integer.parseInt(day[2]);
            int trans_day = year*28*12 + month*28 + date - 1;
            
            if(trans_today > trans_day) answer.add(i+1);
            
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}