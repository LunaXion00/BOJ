import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        Arrays.sort(data, (o1, o2)->{
            if(o1[0] == o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        for(int i= 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int p1_x = data[i][0], p1_y = data[i][1];
                int p2_x = data[j][0], p2_y = data[j][1];
                if(p1_x == p2_x || p1_y == p2_y) continue;
                boolean flag = true;
                for(int k = i+1; k<j; k++){
                    int p3_x = data[k][0], p3_y = data[k][1];
                    if(p1_x < p3_x && p3_x < p2_x && Math.min(p1_y, p2_y) < p3_y && p3_y < Math.max(p1_y, p2_y)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }
} 