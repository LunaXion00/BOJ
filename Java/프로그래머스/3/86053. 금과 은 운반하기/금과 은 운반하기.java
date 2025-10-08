class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long low = 1;
        long high = (long)(10e9 * 2 * 10e5 * 2);
        int len = g.length;
        while(low<=high){
            long mid = (low+high)/2;
            int gold = 0, silver = 0, total = 0;
            for(int i = 0; i<len; i++){
                int weight = w[i];
                int time = t[i];
                long cnt = mid/(time*2);
                if(mid%(time*2)>= time) cnt++;
                gold += Math.min(g[i], weight*cnt);
                silver += Math.min(s[i], weight*cnt);
                total += Math.min(g[i]+s[i], weight*cnt);
            }
            if(gold >= a && silver >= b && total >= a+b){
                answer = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return answer;
    }
}