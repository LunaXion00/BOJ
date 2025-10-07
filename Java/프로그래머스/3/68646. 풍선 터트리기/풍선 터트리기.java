class Solution {
    public int solution(int[] a) {
        int answer = 2;
        if(a.length == 1) return 1;
        int[] leftmin = new int[a.length];
        int[] rightmin = new int[a.length];
        int l = a[0];
        int r = a[a.length-1];
        for(int i = 1; i<a.length - 1; i++){
            if(l > a[i]) l = a[i];
            leftmin[i] = l;
        }
        for(int i = a.length-2; i>=0; i--){
            if(r > a[i]) r = a[i];
            rightmin[i] = r;
        }
        for(int i = 1; i<a.length-1; i++){
            if(leftmin[i]<a[i] && rightmin[i]<a[i]) continue;
            answer++;
        }
        return answer;
    }
}