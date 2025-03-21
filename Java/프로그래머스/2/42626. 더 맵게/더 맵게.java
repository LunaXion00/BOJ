import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for(int i : scoville) pq.add(i);
        while(pq.size()>1){
            int first = pq.poll();
            if(first >= K) return answer;
            int second = pq.poll();
            pq.add(first+second*2);
            answer++;
        }
        if(pq.poll()<K) return -1;
        return answer;
    }
}