import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<String> order;
    static class Node{
        int x;
        int y;
        int move;
        public Node(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int card = 0;
        for(int i = 0; i<board.length; i++) for(int j = 0; j<board[i].length; j++) if(board[i][j] != 0) card++;
        order = new ArrayList<>();
        perm("", 0, card/2);
        for(String s : order){
            String[] cards = s.split("");
            int count = 0;
            int[] pos = new int[]{r, c};
            int[][] copy = new int[4][4];
            for(int i = 0; i<board.length; i++) for(int j = 0; j<board[i].length; j++) copy[i][j] = board[i][j];
            for(String target : cards){
                int num = Integer.parseInt(target);
                count += search(pos, num, copy);
                copy[pos[0]][pos[1]] = 0;
                count += 1;
                count += search(pos, num, copy);
                copy[pos[0]][pos[1]] = 0;
                count += 1;
            }
            answer = Math.min(count, answer);
        }
        return answer;
    }
    private static void perm(String s, int depth, int card){
        if(depth == card){
            order.add(s);
            return;
        }
        for(int i = 1; i<=card; i++){
            if(!s.contains(String.valueOf(i))) perm(s+i, depth+1, card);
        }
    }
    private static int search(int[] pos, int num, int[][] board){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        int x = pos[0];
        int y = pos[1];
        visited[x][y] = true;
        q.add(new Node(x, y, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            if(board[cx][cy] == num){
                pos[0] = cx;
                pos[1] = cy;
                return cur.move;
            }
            for(int i = 0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx >3 || ny > 3 || nx < 0 || ny < 0) continue;
                if(visited[nx][ny]) continue;
                q.add(new Node(nx, ny, cur.move+1));
            }
            for(int i = 0; i<4; i++){
                Node next = ctrl(cx, cy, i, board);
				
				if(next.x==x && next.y ==y) continue;
				if(visited[next.x][next.y]) continue;
				
				visited[next.x][next.y] = true;
				q.add(new Node(next.x,next.y, cur.move+1));
            }
        }
        return 0;
    }
    private static Node ctrl(int x, int y, int dir, int[][] board){
        x += dx[dir];
        y += dy[dir];
        while(x >= 0 && x < 4 && y >= 0 && y < 4) {
            if(board[x][y] != 0) return new Node(x, y, 0);
			x += dx[dir];
			y += dy[dir];
        }
        return new Node(x-dx[dir], y-dy[dir], 0);
    }
}