class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n+1][m+1];
        for(int[] command: skill){
            int flag = command[0]==1?-1:1;
            sum[command[1]][command[2]] += flag*command[5];
            sum[command[1]][command[4]+1] += -1*flag*command[5];
            sum[command[3]+1][command[2]] += -1*flag*command[5];
            sum[command[3]+1][command[4]+1] += flag*command[5];
        }
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=m-1; j++){
                sum[i][j+1] += sum[i][j];
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n-1; j++){
                sum[j+1][i] += sum[j][i];
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(sum[i][j] + board[i][j] > 0 ) answer++;
            }
        }
        return answer;
    }
}