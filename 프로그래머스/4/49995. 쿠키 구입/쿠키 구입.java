import java.util.*;
class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        for(int i = 0; i<cookie.length-1; i++){
            int left = i;
            int right = i+1;
            int left_sum = cookie[left];
            int right_sum = cookie[right];
            while(true){
                if(left_sum == right_sum && answer < left_sum){
                    answer = left_sum;
                } else if(left_sum <= right_sum && left > 0){
                    left_sum += cookie[--left];
                } else if(right_sum < left_sum && right < cookie.length-1){
                    right_sum += cookie[++right];
                } else break;
            }
        }
        return answer;
    }
}