import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        for(String[] board:places){
            boolean flag = false;
            for(int i = 0; i<5; i++){
                for(int j = 0; j<5; j++){
                    if(board[i].charAt(j) == 'P'){
                        if(!bfs(i, j, board)){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag) break;
            }
            answer.add(flag?0:1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    public boolean bfs(int x, int y, String[] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i =0 ; i<4; i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx>=5||ny>=5||nx<0||ny<0||(nx==x&&ny==y)) continue;
                int distance = Math.abs(nx-x) + Math.abs(ny-y);
                if(board[nx].charAt(ny) == 'P' && distance<=2) return false;
                if(board[nx].charAt(ny) == 'O' && distance<2) q.add(new int[]{nx, ny});
            }
        }
        return true;
    }
}