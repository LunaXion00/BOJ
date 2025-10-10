class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;
        long r1 = x, r2 = x, c1 = y, c2 = y;
        for(int i = queries.length-1; i>=0; i--){
            int command = queries[i][0];
            int distance = queries[i][1];
            if(command == 0){
                if(c1 != 0) c1 += distance;
                c2 = Math.min(c2+distance, m-1);
                if(c1 > m-1) return 0;
            } 
            else if(command == 1){
                if(c2 != m-1) c2 -= distance;
                c1 = Math.max(c1-distance, 0);
                if(c2 <0) return 0;
            }
            else if(command == 2){
                if(r1 != 0) r1 += distance;
                r2 = Math.min(r2+distance, n-1);
                if(r1 > n-1) return 0;
            }
            else{
                if(r2 != n-1) r2 -= distance;
                r1 = Math.max(r1-distance, 0);
                if(r2 <0) return 0;
            }
        }
        return (r2-r1+1)*(c2-c1+1);
    }
}