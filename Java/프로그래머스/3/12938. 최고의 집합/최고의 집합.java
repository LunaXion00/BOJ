class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s) return new int[] {-1};
        else{
            int cnt = s%n;
            for(int i = n-1; i>=0; i--) {
                answer[i] = s/n;
                if(cnt>0) {
                    answer[i]++;
                    cnt--;
                }
            }
        }
        return answer;
    }
}