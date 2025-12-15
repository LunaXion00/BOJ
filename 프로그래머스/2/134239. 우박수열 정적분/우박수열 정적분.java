import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        int n = 0;
        while(true){
            list.add(k);
            if(k == 1) break;
            k = k%2 == 1 ? k*3+1 : k/2;
            n++;
        }
        double[] yValue = list.stream().mapToDouble(i->i).toArray();
        double[] area = new double[n+1];
        double[] sum = new double[n+1];
        
        for(int i = 1; i<=n; i++) area[i] = (yValue[i]+yValue[i-1])/2;
        
        sum[1] = area[1];
        for(int i = 2; i<=n; i++) sum[i] = sum[i-1]+area[i];
        
        for(int i = 0; i<ranges.length; i++){
            int start = ranges[i][0], end = n+ranges[i][1];
            if(end > start) answer[i] = sum[end]-sum[start];
            else if (end < start) answer[i] = -1.0;
            else answer[i] = 0.0;
        }
        return answer;
    }
}