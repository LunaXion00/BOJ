import java.util.*;
class Solution {
    int[] parents;
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for(int i = 0; i<n; i++) parents[i] = i;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(computers[i][j] == 1) union(i, j);
            }
        }
        Set<Integer> answer = new HashSet<>();
        for(int i = 0; i<n; i++) parents[i] = find(i);
        for(int i = 0; i<n; i++) answer.add(parents[i]);
        return answer.size();
    }
    public int find(int a){
        if(parents[a]==a) return a;
        else return parents[a] = find(parents[a]);
    }
    public void union(int a,int b){
        int x= find(a);
        int y = find(b);
        if(x==y) return;
        else parents[x] = y;
    }
}