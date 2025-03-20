import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> o1[1]-o2[1]);
        int index = 0;
        int cnt = 0;
        int time = 0;
        int end = 0;
        while(cnt < jobs.length){
            while(index<jobs.length && jobs[index][0]<=end){
                pq.add(jobs[index++]);
            }
            if(pq.isEmpty()) end = jobs[index][0];
            else{
                int[] cur = pq.poll();
                time += cur[1] +end - cur[0];
                end += cur[1];
                cnt++;
            }
        }
        return time/jobs.length;
    }
}