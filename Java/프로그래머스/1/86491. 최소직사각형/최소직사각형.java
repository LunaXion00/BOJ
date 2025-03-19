class Solution {
    public int solution(int[][] sizes) {
        int mx = Integer.MIN_VALUE;
        int my = Integer.MIN_VALUE;
        for(int i = 0; i<sizes.length; i++){
            mx = Math.max(mx, Math.max(sizes[i][0], sizes[i][1]));
            my = Math.max(my, Math.min(sizes[i][0], sizes[i][1]));
        }
        return mx*my;
    }
}