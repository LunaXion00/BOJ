import java.util.*;
class Solution {
    static int N, answer = 0;
    static List<List<Integer>> tree = new ArrayList<>();
    public int solution(int n, int[][] lighthouse) {
        N = n;
        for(int i = 0; i<=N; i++) tree.add(new ArrayList<>());
        for(int i = 0; i<lighthouse.length; i++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1, 0);
        return answer;
    }
    public int dfs(int cur, int parent){
        if(tree.get(cur).size() == 1 && tree.get(cur).get(0) == parent){
            return 1;
        }
        int temp = 0;
        for(int i = 0; i<tree.get(cur).size(); i++){
            int next = tree.get(cur).get(i);
            if(next == parent) continue;
            temp += dfs(next, cur);
        }
        if(temp == 0)return 1;
        answer++;
        return 0;
    }
}