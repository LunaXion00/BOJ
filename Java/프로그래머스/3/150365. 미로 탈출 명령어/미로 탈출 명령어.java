class Solution {
    static String answer = "z";
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, -1, 1, 0};
    static int N, M, R, C, K;
    static String[] dir = {"d", "l", "r", "u"};
    
    public static int calc_dist(int y, int x){
        return Math.abs(R-y)+Math.abs(C-x);
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; 
        M = m; 
        R = r-1; 
        C = c-1; 
        K = k;
        if(calc_dist(y-1, x-1) > K || (K-calc_dist(y-1, x-1))%2==1) return "impossible";
        find(x-1, y-1, 0, "");
        return answer;
    }
    public static void find(int a, int b, int length, String command){
        if(length + calc_dist(a, b) > K || command.compareTo(answer) > 0){
            return;
        }
        if(length == K && a == R && b == C){
            answer = command;
            return;
        }
        for(int i = 0; i<4; i++){
            int nx = b+dx[i];
            int ny = a+dy[i];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            find(ny, nx, length+1, command+dir[i]);
        }
    }
}