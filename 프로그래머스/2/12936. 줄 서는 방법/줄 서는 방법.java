import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();
        long div = 1;
        for(int i = 1; i<=n; i++){
            div *= i;
            nums.add(i);
        }
        k--;
        int index = 0;
        while(index < n){
            div /= (n-index);
            answer[index++] = nums.remove((int)(k/div));
            k = k%div;
        }
        return answer;
    }
}