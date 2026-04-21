import java.util.*;
class Solution {
    class Food implements Comparable<Food>{
        int index;
        int time;
        public Food(int index, int time){
            this.index = index;
            this.time = time;
        }
        @Override
        public int compareTo(Food o){
            return this.time - o.time;
        }
    }
    static PriorityQueue<Food> pq;
    public int solution(int[] food_times, long k) {
        long sum = 0;
        pq = new PriorityQueue<>();
        for(int i = 0; i<food_times.length; i++) {
            sum += food_times[i];
            pq.offer(new Food(i+1, food_times[i]));
        }
        if(sum <= k) return -1;
        sum = 0;
        int last = 0;
        while(!pq.isEmpty()){
            // 가장 짧은 시간이 남은 음식을 다 먹을 때까지 추가로 걸리는 시간. 
            Food minimum = pq.poll();
            sum += (long)(minimum.time-last) * (pq.size() + 1);
            if(sum >= k){
                pq.offer(minimum);
                sum -= (long)(minimum.time-last) * pq.size();
                break;
            }
            last = minimum.time;
        }
        List<Integer> remain = new ArrayList<>();
        while(!pq.isEmpty()){
            remain.add(pq.poll().index);
        }
        Collections.sort(remain);
        return remain.get((int)((k - sum) % remain.size()));
    }
}