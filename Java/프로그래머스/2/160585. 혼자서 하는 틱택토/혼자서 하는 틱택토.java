class Solution {
    static int cnt_o;
    static int cnt_x;
    static boolean made_o = false;
    static boolean made_x = false;
    public int solution(String[] board) {
        check(board);
        if(cnt_o < cnt_x || cnt_o -cnt_x > 1) return 0;
        if(made_o && made_x) return 0;
        if(made_o &&(cnt_o== cnt_x)) return 0;
        if(made_x && (cnt_o > cnt_x)) return 0;
        return 1;
    }
    public static void check(String[] board){
        cnt_o = 0;
        cnt_x = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[i].charAt(j) == 'O') cnt_o++;
                else if(board[i].charAt(j) == 'X') cnt_x++;
            }
        }
        for(int i = 0; i<3; i++){
            if(board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)){
                if(board[i].charAt(0) == 'X') made_x = true;
                else if(board[i].charAt(0) == 'O') made_o = true;
            }
            if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)){
                if(board[0].charAt(i) == 'X') made_x = true;
                else if(board[0].charAt(i) == 'O') made_o = true;
            }
        }
        if(board[0].charAt(0) == board[1].charAt(1) &&board[0].charAt(0) == board[2].charAt(2)){
            if(board[0].charAt(0) == 'X') made_x = true;
            else if(board[0].charAt(0) == 'O') made_o = true;
        }
        if(board[0].charAt(2) == board[1].charAt(1) &&board[2].charAt(0) == board[1].charAt(1)){
            if(board[0].charAt(2) == 'X') made_x = true;
            else if(board[0].charAt(2) == 'O') made_o = true;
        }
    }
}