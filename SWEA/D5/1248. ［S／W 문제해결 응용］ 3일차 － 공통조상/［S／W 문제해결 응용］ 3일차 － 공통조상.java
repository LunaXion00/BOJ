import java.util.Scanner;
import java.util.*;

class Solution {
    static int[] depths;
    static boolean[] visited;
    static List<List<Integer>> tree;
    // parent[i][j]는 node i의 2^j번째 조상을 의미. j=0이면 부모, j = 1이면 부모의 부모, ...
    static int[][] parent;
    static int[] subTreeSize;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int t = 1; t <= T; t++) {
            int V = sc.nextInt(), E =  sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            int h = getHeight(V);
            tree = new ArrayList<>();
            visited = new boolean[V+1];
            parent = new int[V+1][h];
            depths = new int[V+1];
            subTreeSize = new int[V+1];

            for(int i = 0; i<V+1; i++) tree.add(new ArrayList<>());
            for(int i = 0; i<E; i++){
                int p = sc.nextInt(), c = sc.nextInt();
                tree.get(p).add(c);
            }
            dfs(1, 0);
            setParent(V, h);
            int common = lca(a,b,h);
            System.out.println("#"+t+" " + common+ " "+ subTreeSize[common]);
        }
    }
    private static int getHeight(int v){
        return (int) Math.ceil(Math.log(v) / Math.log(2)) + 1;
    }
    private static int dfs(int node, int depth){
        visited[node] = true;
        depths[node] = depth;
        subTreeSize[node] = 1;
        for(int next : tree.get(node)){
            if(visited[next]) continue;
            parent[next][0] = node;
            subTreeSize[node] += dfs(next, depth+1);
        }
        return subTreeSize[node];
    }
    private static int lca(int a, int b, int h){
        // 더 깊은 노드를 a로 지정
        if(depths[a]<depths[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 출발 높이를 동일하게 맞추기.
        for(int i = h-1; i >= 0; i--){
            if(depths[a] - depths[b] >= (1 << i)) a = parent[a][i];
        }
        // 만약 같으면? 그대로 반환
        if(a == b) return a;

        for(int i = h-1; i>= 0; i--){
            if(parent[b][i] != parent[a][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
    private static void setParent(int n, int h){
        for(int j = 1; j<h; j++){
            for(int i = 1; i<=n; i++){
                parent[i][j] = parent[parent[i][j-1]][j-1];
            }
        }
    }
}