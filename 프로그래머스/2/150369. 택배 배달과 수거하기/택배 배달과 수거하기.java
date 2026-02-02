import java.util.*;
class Solution {
    class Info implements Comparable<Info>{
        int position;
        int remain;
        public Info(int position, int remain){
            this.position = position;
            this.remain = remain;
        }
        @Override
        public int compareTo(Info o1){
            return o1.position - this.position;
        }
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        PriorityQueue<Info> delivery = new PriorityQueue<>();
        PriorityQueue<Info> pick = new PriorityQueue<>();
        for(int i = 0; i<deliveries.length; i++){
            if(deliveries[i] != 0) delivery.add(new Info(i+1, deliveries[i]));
            if(pickups[i] != 0) pick.add(new Info(i+1, pickups[i]));
        }
        while(!delivery.isEmpty() || !pick.isEmpty()){
            int count = 0;
            int deliv_latest = 0;
            while(!delivery.isEmpty()){
                Info now = delivery.poll();
                if(deliv_latest == 0) deliv_latest = now.position;
                if(count + now.remain < cap) count += now.remain;
                else if(count + now.remain == cap) break;
                else {
                    delivery.add(new Info(now.position, now.remain-(cap-count)));
                    break;
                }
            }
            count = 0;
            int pick_latest = deliv_latest;
            while(!pick.isEmpty()){
                Info now = pick.poll();
                if(pick_latest < now.position) pick_latest = now.position;
                if(count + now.remain < cap) count += now.remain;
                else if(count + now.remain == cap) break;
                else {
                    pick.add(new Info(now.position, now.remain-(cap-count)));
                    break;
                }
            }
            answer += (Math.max(pick_latest, deliv_latest)*2);
        }
        return answer;
    }
}