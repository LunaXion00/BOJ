class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] cnt = new int[a.length];
        for(int num : a) cnt[num]++;
        for(int i = 0; i<cnt.length; i++){
            if(cnt[i] <= answer) continue;
            int counter = 0;
            for(int j = 0; j<a.length-1; j++){
                if((a[j] == i || a[j+1] == i) && a[j] != a[j+1]) {
                    counter++;
                    j++;
                }
            }
            answer = Math.max(answer, counter);
        }
        return answer*2;
    }
}