import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin)+1];
        for(int i = 0; i<answer.length; i++){
            long num = i+begin;
            if(num == 1) answer[i] = 0;
            else answer[i] = (int)factor(num);
        }
        return answer;
    }
    private long factor(long num){
        long maxDivisor = 1; // 기본값 1

        for (long i = 2; i * i <= num; i++) {   // i <= sqrt(num)
            if (num % i != 0) continue;

            long big = num / i;   // 더 큰 약수

            // 큰 약수가 블록 번호 제한(1천만) 이하라면 이게 곧 최대 약수이므로 바로 리턴
            if (big <= 10_000_000L) {
                return big;
            }

            // 큰 약수가 너무 크면, 작은 쪽(i)을 후보로 저장 (자신 제외 약수)
            if (i <= 10_000_000L) {
                maxDivisor = Math.max(maxDivisor, i);
            }
        }

        return maxDivisor;
    }
}