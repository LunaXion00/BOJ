class Solution {
    static int[] board;
    static int answer;
    public int solution(int n) {
        board = new int[n];
        backTracking(0, n);
        return answer;
    }
    private void backTracking(int depth, int n){
        if(depth == n){
            answer++;
            return;
        }
        for(int i = 0; i<n; i++){
            board[depth] = i;
            if(valid(depth)) backTracking(depth+1, n);
        }
    }
    private boolean valid(int depth){
        for (int i = 0; i < depth; i++) { 
            if (board[depth] == board[i]) return false;
            if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) return false;
        }
        return true;
    }
}