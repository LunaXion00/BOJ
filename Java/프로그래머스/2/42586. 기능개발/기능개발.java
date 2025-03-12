import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<progresses.length; i++) {
            q.add((100-progresses[i])%speeds[i]!=0?(100-progresses[i])/speeds[i]+1:(100-progresses[i])/speeds[i]);
        }
        int day = q.poll();
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(day>=cur) cnt++;
            else{
                list.add(cnt);
                day = cur;
                cnt =1;
            }
        }
        list.add(cnt);
        return list.stream().mapToInt(i->i).toArray();
    }
}