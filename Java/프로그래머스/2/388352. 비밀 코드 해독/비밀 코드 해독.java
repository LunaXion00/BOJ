import java.util.*;
class Solution {
    static int answer = 0;
    static Set<Integer> code = new HashSet<>();
    static int[][] call;
    static int[] response;
    static int limit;
    public int solution(int n, int[][] q, int[] ans) {
        // 최대 n = 30에 대해서, 가능한 조합의 수 30C5 = 142506개. 이정도면 모든 경우에 대해 계산해도 될 것 같음.
        limit = n+1;
        call = q;
        response = ans;
        dfs(0, 1);
        return answer;
    }
    public void dfs(int level, int start){
        if(level == 5){
            if(check()) answer++;
            return;
        }
        for(int i = start; i<limit; i++){
            code.add(i);
            dfs(level+1, i+1);
            code.remove(i);
        }
    }
    public boolean check(){
        for(int i = 0; i<call.length; i++){
            int cnt = 0;
            for(int j = 0; j<call[i].length; j++){
                if(code.contains(call[i][j])) cnt++;
            }
            if(cnt != response[i]) return false;
        }
        return true;
    }
}