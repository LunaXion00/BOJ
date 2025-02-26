import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] r1, int[] r2){
                return r1[1]-r2[1];
            }
        });
        int camera = -30001;
        for(int[] pos:routes){
            if(camera<pos[0]){
                camera = pos[1];
                answer++;
            }
        }
        return answer;
    }
}