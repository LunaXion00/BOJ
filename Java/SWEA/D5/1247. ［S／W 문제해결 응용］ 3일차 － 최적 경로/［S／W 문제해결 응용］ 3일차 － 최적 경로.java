import java.io.*;
import java.util.*;

public class Solution {
    static int N, answer;
    static int[][] pos;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int t = 0; t<T; t++){
            N = sc.nextInt();
            pos = new int[N+2][2];
            visited = new boolean[N];
            // pos[0]은 회사, pos[1]은 집, 그 이후는 방문해야할 집들.
            for(int i = 0; i<N+2; i++){
                pos[i][0] = sc.nextInt();
                pos[i][1] = sc.nextInt();
            }
            answer = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println("#"+(t+1)+" "+answer);
        }
    }
    private static void dfs(int cur, int cnt, int dist){
        if(dist > answer) return;
        if(cnt == N){
            // 모든 노드 순환이 끝났으면 해당 위치에서 집까지의 거리를 추가.
            answer = Math.min(answer, dist+getDist(cur, 1));
            return;
        }
        for(int i = 2; i<pos.length; i++){
            if(!visited[i-2]){
                visited[i-2] = true;
                dfs(i, cnt+1, dist+getDist(cur, i));
                visited[i-2] = false;
            }
        }
    }
    private static int getDist(int a, int b){
        return Math.abs(pos[a][0]-pos[b][0])+Math.abs(pos[a][1]-pos[b][1]);
    }
}