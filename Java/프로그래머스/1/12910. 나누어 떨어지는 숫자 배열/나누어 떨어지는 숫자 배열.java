import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int count = 0;
        for(int i : arr) if(i%divisor == 0) count += 1;
        if(count == 0) return new int[]{-1};
        else {
            answer = new int[count];
            int index = 0;
            for(int i:arr) if(i%divisor == 0) answer[index++] = i;
            Arrays.sort(answer);
            return answer;
        }
    }
}