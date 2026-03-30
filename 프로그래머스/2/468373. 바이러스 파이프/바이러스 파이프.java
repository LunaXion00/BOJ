import java.util.*;
class Solution {
    // edge에 대한 정보.
    class Pipe{
        int dest;
        int type;
        public Pipe(int dest, int type){
            this.dest = dest;
            this.type = type;
        }
    }
    static List<List<Pipe>> graph = new ArrayList<>();
    static int N, answer, K, first;
    static int[] order;
    public int solution(int n, int infection, int[][] edges, int k) {
        N = n; answer = 0; K = k; first = infection;
        order = new int[k];
        for(int i = 0; i<n+1; i++) graph.add(new ArrayList<>());
        for(int[] edge: edges){
            int x = edge[0], y = edge[1], type = edge[2];
            graph.get(x).add(new Pipe(y, type));
            graph.get(y).add(new Pipe(x, type));
        }
        brute(0, -1);
        return answer;
    }
    // 파이프의 순서를 정한 후, 그 순서에 따라 시뮬레이션 진행.
    private void brute(int depth, int last){
        if(depth == K){
            answer = Math.max(answer, simulate());
            return;
        }
        for(int i = 1; i<=3; i++){
            if(last == i) continue;
            order[depth] = i;
            brute(depth+1, i);
        }
    }
    private int simulate(){
        List<Integer> infected = new ArrayList<>();
        infected.add(first);
        for(int i = 0 ; i<order.length; i++){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N+1];
            for(int n:infected) {
                q.offer(n);
                visited[n] = true;
            }
            while(!q.isEmpty()){
                int now = q.poll();
                for(Pipe next : graph.get(now)){
                    if(next.type == order[i] && !visited[next.dest]){
                        infected.add(next.dest);
                        q.offer(next.dest);
                        visited[next.dest] = true;
                    }
                }
            }
        }
        return infected.size();
    }
}