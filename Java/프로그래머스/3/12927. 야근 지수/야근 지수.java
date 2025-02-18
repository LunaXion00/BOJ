import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< works.length; i++){
            q.offer(works[i]);
        }
        while(n>0){
            int work = q.poll();
            if(work==0) break;
            work--;
            q.offer(work);
            n--;
        }
        for(int w : q){
            answer += w*w;
        }
        return answer;
    }
}