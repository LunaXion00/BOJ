class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length-1};
        int start = 0, end = 1, sum = sequence[0];
        if(sum == k) return new int[]{0,0};
        while(start < end){
            if(sum == k) {
                if(end-start-1 < answer[1]-answer[0]){
                    answer[0] = start;
                    answer[1] = end-1;
                }
                sum -= sequence[start++];
            } else if(sum > k){
                sum -= sequence[start++];
            } else if(end < sequence.length){
                sum += sequence[end++];
            } else {
                break;
            }
        }
        return answer;
    }
}