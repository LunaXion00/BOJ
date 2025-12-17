import java.util.*;
class Solution {
    static int maxdiff = 0;
    static int[] answer;
    static int[] a, b;
    static int N;
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        N = n;
        a = info;
        b = new int[info.length];
        dfs(0, 0);
        if(maxdiff == 0) return new int[]{-1};
        return answer;
    }
    public void dfs(int depth, int arrows){
        if(depth == 11){
            int sum = 0;
            b[10] += (N-arrows);
            int score = calcScore();
            if(score != 0){
                if(score > maxdiff){
                    maxdiff = score;
                    answer = b.clone();
                }
                else if(score == maxdiff){
                    if(check()) answer = b.clone();
                }
            }
            b[10] = 0;
            return;
        }
        if(arrows+a[depth]+1 <= N) {
            b[depth] = a[depth]+1;
            dfs(depth+1, arrows+a[depth]+1);
        }
        b[depth] = 0;
        dfs(depth+1, arrows);
    }
    public int calcScore(){
        int score = 0;
        for(int i = 0; i<a.length;i++){
            if(a[i]<b[i]) score += (10-i);
            else if(a[i] == b[i] && a[i] == 0) continue;
            else score -= (10-i);
        }
        return score;
    }
    public boolean check(){
        for(int i = 10; i>=0;i--){
            if(b[i] > answer[i]) return true;
            else if(b[i] < answer[i]) return false;
        }
        return false;
    }
}