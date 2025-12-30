class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long wl = (long)w;
        long hl = (long)h;
        
        return (wl*hl)-((wl+hl)-gcd(wl, hl));
    }
    private long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}