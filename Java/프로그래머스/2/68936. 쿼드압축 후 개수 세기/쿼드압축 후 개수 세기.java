class Solution {
    static int[][] board;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        board = arr;
        return simulate(0, 0, arr.length, arr[0].length);
    }
    private int[] simulate(int sx, int sy, int ex, int ey){
        int num = board[sx][sy];
        boolean flag = false;
        outer:for(int i = sx; i<ex; i++){
            for(int j= sy; j<ey; j++){
                if(num != board[i][j]) {
                    flag = true;
                    break outer;
                }
            }
        }
        if(flag){
            int[] first = simulate(sx, sy, (sx+ex)/2, (sy+ey)/2);
            int[] second = simulate(sx, (sy+ey)/2, (sx+ex)/2, ey);
            int[] third = simulate((sx+ex)/2, sy, ex, (sy+ey)/2);
            int[] fourth = simulate((sx+ex)/2, (sy+ey)/2, ex, ey);
            return new int[]{first[0]+second[0]+third[0]+fourth[0], first[1]+second[1]+third[1]+fourth[1]};
        }
        else{
            if(num == 0) return new int[]{1, 0};
            else return new int[]{0, 1};
        }
    }
}