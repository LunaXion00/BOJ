class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown/2+2;
        int i=1, j=0;
        for(i = 1; i<sum; i++){
            j = sum-i;
            if((i-2) * (j-2) == yellow) return new int[]{j,i};
        }
        return new int[]{j,i};
    }
}