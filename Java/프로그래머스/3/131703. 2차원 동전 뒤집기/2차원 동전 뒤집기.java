import java.util.*;
class Solution {
    static int N, M;
    static int[][] board;
    static int[][] t;
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        N = beginning.length;
        M = beginning[0].length;
        board = new int[N][M];
        t = target;
        for(int i = 0;i<N; i++) board[i] = beginning[i].clone();
        
        dfs(0, 0);
        if(answer==Integer.MAX_VALUE){
            answer = -1;
        } 
        return answer;
    }
    public void flip(int r){
        for(int i = 0; i<M; i++) board[r][i] = board[r][i] ^ 1;
    }
    public void dfs(int r, int cnt){
        if(r == N){
            boolean flag = true;
            for(int i = 0; i<M; i++){
                int result = compare_col(i);
                if(result == -1){
                    flag = false;
                    break;
                }
                cnt+=result;
            }
            if(flag) answer = Math.min(cnt, answer);
            return;
        }
        flip(r);
        dfs(r+1, cnt+1);
        flip(r);
        dfs(r+1, cnt);
    }
    public int compare_col(int c){
        int count = 0;
        for(int i = 0; i<N; i++){
            if(board[i][c] == t[i][c]) count++;
        }
        if(count == 0) return 1;
        else if(count == N) return 0;
        else return -1;
    }
}