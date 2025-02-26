class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for(int station:stations){
            int T = station-w-start;
            if(T>0){
                int q = T/(w*2+1);
                int r = T%(w*2+1);
                answer += q+(r==0?0:1);
            }
            start = station+w+1;
        }
        if(start<=n){
            int T = n-start+1;
            int q = T/(w*2+1);
            int r = T%(w*2+1);
            answer += q+(r==0?0:1);
        }
        return answer;
    }
}