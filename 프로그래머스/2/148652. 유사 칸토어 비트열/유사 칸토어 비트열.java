class Solution {
    public int solution(int n, long l, long r) {
        return count(n, l - 1, r - 1);
    }
    private int count(int n, long start, long end) {
        if(n == 0) {
            return 1;
        }
        long length = (long)Math.pow(5, n);
        long segmentLen = length / 5;
        
        int total = 0;
        
        for(int i = 0; i < 5; i++) {
            long segStart = segmentLen * i;
            long segEnd = segStart + segmentLen - 1;

            if(segEnd < start || segStart > end) {
                continue; 
            }
            // 전에 있던 수가 1이건, 0이건 항상 가운데 인덱스는 0을 표시. 즉, 구간을 5등분 했을 때, 3번째 구간은 항상 0으로만 구성.
            if(i == 2) {
                continue;
            }
            long overlapStart = Math.max(start, segStart) - segStart;
            long overlapEnd = Math.min(end, segEnd) - segStart;

            total += count(n - 1, overlapStart, overlapEnd);
        }
        
        return total;
    }
}