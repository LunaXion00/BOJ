import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min_level = 1;
        int max_level = Arrays.stream(diffs).max().getAsInt();
        while(min_level<max_level){
            int level = (min_level+max_level)/2;
            long time = 0;
            int prev_time = 0;
            for(int i = 0; i<diffs.length; i++){
                if(diffs[i]<=level){
                    time += times[i];
                    prev_time = times[i];
                }else{
                    time += (times[i]+prev_time)*(diffs[i]-level)+times[i];
                    prev_time = times[i];
                }
            }
            if(time == limit) return level;
            else if(time < limit) max_level = level;
            else min_level = level+1;
        }
        return max_level;
    }
}