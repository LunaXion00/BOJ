import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.add(i);
        while(pq.size()>=2){
            int min = pq.poll();
            if(min >=K) return answer;
            int next_min = pq.poll();
            pq.add(min+next_min*2);
            answer++;
        }
        if(pq.poll()>=K) return answer;
        return -1;
    }
}