import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> rec = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();
        int end = 23*60+59;
        for(String s : records){
            String[] log = s.split(" ");
            if(log[2].equals("IN")){
                int time = convertTime(log[0]);
                rec.put(log[1], time);
            } else{
                int time = rec.get(log[1]);
                total.put(log[1], total.getOrDefault(log[1], 0)+convertTime(log[0])-time);
                rec.remove(log[1]);
            }
        }
        List<String> remain = new ArrayList<>(rec.keySet());
        for(String car:remain){
            int time = rec.get(car);
            total.put(car, total.getOrDefault(car, 0)+end-time);
        }
        // total은 차량 번호 + 총 이용시간으로 구성된 Hash
        List<String> fin = new ArrayList<>(total.keySet());
        fin.sort((s1, s2)-> s1.compareTo(s2));
        for(String f : fin){
            answer.add(calculate(total.get(f), fees));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    public int convertTime(String t){
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    public int calculate(int time, int[] fees){
        int total = fees[1];
        if(time<=fees[0]) return total;
        time = time-fees[0];
        total += time/fees[2] * fees[3];
        if(time%fees[2]!=0) total += fees[3];
        return total;
    }
}