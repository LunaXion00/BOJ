import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2)->o1[1] - o2[1]);
        int point = 0;
        for(int[] p: targets){
            if(point <= p[0]) {
                point = p[1];
                answer++;
            }
        }
        return answer;
    }
}