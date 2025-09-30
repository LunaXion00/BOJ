class Solution {
    public int solution(int n, int[] cores) {
        int min = 0, max = 10000*n; 
        int answer = 0;
        int work = 0, time = 0;
        // 작업이 끝난 시간 찾기
        while(min <= max){
            int mid = (min+max)/2;
            int cnt = calc(mid, cores);
            if(cnt >= n){
                max = mid-1;
                time = mid;
                work = cnt;
            }
            else{
                min = mid+1;
            }
        }
        
        for(int i = cores.length-1; i>=0; i--){
            if(time%cores[i] == 0){
                if(work == n) {
                    answer = i+1;
                    break;
                }
                work--;
            }
        }
        return answer;
    }
    public static int calc(int mid, int[] cores){
        // 해당 시간(mid)에 몇개의 작업이 수행되었는지.
        int cnt = cores.length;
        for(int core : cores) cnt += mid/core;
        return cnt;
    }
}