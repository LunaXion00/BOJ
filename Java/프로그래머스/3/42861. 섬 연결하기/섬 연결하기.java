import java.util.*;
class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2]- o2[2];
            };
        });
        parents = new int[n];
        for(int i = 0; i<n; i++) parents[i] = i;
        for(int i = 0; i<costs.length; i++){
            if(union(costs[i][0], costs[i][1])) answer += costs[i][2];
        }
        return answer;
    }
    private static boolean union(int a, int b){
        int r1 = find(a);
        int r2 = find(b);
        if(r1 == r2) return false;
        if(r1 > r2) parents[r2] = r1;
        else parents[r1] = r2;
        return true;
    }
    private static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}