import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 0, right = distance;
        while(left <= right){
            int mid = (left+right)/2;
            int count = 0, last = 0;
            for(int location : rocks){
                if(location - last < mid) count++;
                else{
                    last = location;
                }
            }
            if(distance - last < mid) count++;
            if(count <= n){
                answer = mid;
                left = mid+1;
            } else{
                right = mid - 1;
            }
        }
        return answer;
    }
}