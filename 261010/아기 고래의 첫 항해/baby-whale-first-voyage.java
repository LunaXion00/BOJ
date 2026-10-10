import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int x;
        int y;
        int dir;
        int level;
        public Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.level = 0;
        }
        public Node(int x, int y, int dir, int level){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.level = level;
        }
    }
    static boolean[][] visited;
    static int[][] board;
    static int N;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int[] prior = {3, 2, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int r = Integer.parseInt(st.nextToken())- 1, c = Integer.parseInt(st.nextToken()) - 1, dir = Integer.parseInt(st.nextToken()) % 4;
        
        List<Node> answer = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N][N];
        board = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.offer(new Node(r, c, dir));

        while(!q.isEmpty()){
            Node now = q.poll();
            answer.add(now);
            visited[now.x][now.y] = true;
            boolean flag = true;
            for(int i = 0; i<4; i++){
                int ndir = next_dir(now.dir, i);
                int nx = now.x + dx[ndir];
                int ny = now.y + dy[ndir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny] || board[nx][ny] == 1) continue;
                flag = false;
                q.offer(new Node(nx, ny, ndir));
                break;
            }
            if(flag){
                Node next = find_next(now);
                if(next.dir == -1) break;
                q.offer(next);
            }
        }
        for(Node node : answer){
            System.out.printf("%d %d\n", node.x+1, node.y+1);
        }
    }
    private static Node find_next(Node n){
        boolean[][] new_visited = new boolean[N][N];
        Node candidate = new Node(51, 51, -1, 200);
        Queue<Node> bfs = new LinkedList<>();
        bfs.offer(n);
        new_visited[n.x][n.y] = true;
        while(!bfs.isEmpty()){
            Node now = bfs.poll();
            if(now.level > candidate.level) return candidate;
            for(int i : prior){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if(nx < 0 || ny < 0 || nx>=N || ny >= N) continue;
                if(board[nx][ny] == 1 || new_visited[nx][ny]) continue;
                new_visited[nx][ny] = true;
                if(!visited[nx][ny] && candidate.level > now.level){
                    if(nx < candidate.x) {
                        candidate = new Node(nx, ny, i, now.level+1);
                    } else if(nx == candidate.x && ny < candidate.y){
                        candidate = new Node(nx, ny, i, now.level+1);
                    }
                }
                bfs.offer(new Node(nx, ny, i, now.level+1));
            }
        }
        return candidate;
    }
    private static int next_dir(int dir, int count){
        if(count == 0){
            return dir;
        }
        else if(count == 3){
            return (3 - dir);
        }
        else if(count == 1){
            if(dir == 0 || dir == 3) return (5 - dir) % 4;
            else return (dir + 2) % 4;
        }
        else{
            if(dir == 0 || dir == 3) return (dir + 2) % 4;
            else return (5 - dir) % 4;
        }
    }
}