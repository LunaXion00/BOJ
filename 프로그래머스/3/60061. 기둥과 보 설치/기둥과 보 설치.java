class Solution {
    static boolean[][] pole;
    static boolean[][] floor;
    static int N;
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        int count = 0;
        pole = new boolean[n+1][n+1];
        floor = new boolean[n+1][n+1];
        for(int i = 0; i<build_frame.length; i++){
            int[] commands = build_frame[i];
            int x = commands[0];
            int y = commands[1];
            int type = commands[2]; // 0은 기둥, 1은 보
            int command = commands[3]; // 0은 삭제, 1은 설치.
            if(command == 0){
                if(type == 0){
                    pole[x][y] = false;
                    if(available() == false) pole[x][y] = true;
                    else count--;
                }
                else{
                    floor[x][y] = false;
                    if(available() == false) floor[x][y] = true;
                    else count--;
                }
            } 
            else if(command == 1){
                if(type == 1){
                    if(checkFloor(x,y)){
                        floor[x][y] = true;
                        count++;
                    }
                }
                else{
                    if(checkPole(x,y)){
                        pole[x][y] = true;
                        count++;
                    }
                }
            }
        }
        int[][] answer = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pole[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j; 
                    answer[idx++][2] = 0;
                }
                if(floor[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }
    private static boolean available(){
        for(int i = 0; i <= N; i++) { 
            for(int j = 0; j <= N; j++) { 
                if(pole[i][j] && checkPole(i, j) == false)  return false; 
                else if(floor[i][j] && checkFloor(i, j) == false) return false; 
            }
        }
        return true;
    }
    private static boolean checkPole(int x, int y) {
        if(y == 0) return true; 
        else if(y > 0 && pole[x][y - 1]) return true;
        else if(x > 0 && floor[x - 1][y] || floor[x][y]) return true;
        return false;
    }
    
    private static boolean checkFloor(int x, int y) {
        if(y > 0 && pole[x][y - 1] || pole[x + 1][y - 1]) return true; 
        else if(x > 0 && floor[x - 1][y] && floor[x + 1][y]) return true; 
        return false;
    }
}