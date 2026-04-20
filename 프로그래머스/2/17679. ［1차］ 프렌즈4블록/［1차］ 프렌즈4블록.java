import java.util.*;
class Solution {
    static char[][] cboard;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N = n;
        M = m;
        cboard = new char[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++) cboard[i][j] = board[i].charAt(j);
        }
        while(true){
            boolean[][] deleted = new boolean[m][n];
            boolean flag = false;
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n-1; j++){
                    if(cboard[i][j] == '.') continue;
                    if(cboard[i][j] == cboard[i][j+1] && cboard[i][j] == cboard[i+1][j] && cboard[i][j] == cboard[i+1][j+1] ){
                        deleted[i][j] = deleted[i][j+1] = deleted[i+1][j] = deleted[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            if(!flag) break;
            int count = 0;
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(deleted[i][j]) {
                        cboard[i][j] = '.';
                        count++;
                    }
                }
            }
            answer += count;
            goDown();
        }
        return answer;
    }
    static private void goDown(){
        for(int i = 0; i<N; i++){
            int length = 0;
            for(int j = M-1; j >= 0 ; j--){
                if(cboard[j][i] == '.'){
                    length++;
                    continue;
                }
                if(length > 0 && cboard[j][i] != '.'){
                    for(int k = j+length; k>=length; k--){
                        cboard[k][i] = cboard[k-length][i];
                    }
                    for(int k = length-1 ; k>= 0; k--){
                        cboard[k][i] = '.';
                    }
                    j += length;
                    length = 0;
                }
            }
        }
    }
}