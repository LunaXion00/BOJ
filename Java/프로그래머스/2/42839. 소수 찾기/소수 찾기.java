import java.util.*;
class Solution {
    boolean[] visited;
    Set<Integer> nums = new HashSet<>();
    int n;
    public int solution(String numbers) {
        int answer = 0;
        n = numbers.length();
        visited = new boolean[n];
        dfs(numbers, "", 0);
        for(int i:nums){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    public void dfs(String numbers, String current, int depth){
        if(depth > n) return;
        for(int i = 0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            String next = current+numbers.charAt(i);
            nums.add(Integer.parseInt(next));
            dfs(numbers, next, depth+1);
            visited[i] = false;
        }
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i = 2; i<=(int)Math.sqrt(n); i++) if(n%i == 0) return false;
        return true;
    }
}