class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        // 1은 (1,-1,1,-1,...), 2는 (-1,1,-1,1,...)
        long pulse_1 = 0, pulse_2 = 0;
        int sign = 1;
        for(int num : sequence){
            pulse_1 += sign*num;
            pulse_2 += sign*(-1)*num;
            pulse_1 = Math.max(0, pulse_1);
            pulse_2 = Math.max(0, pulse_2);
            answer = Math.max(answer, Math.max(pulse_1, pulse_2));
            sign *= -1;
        }
        return answer;
    }
}