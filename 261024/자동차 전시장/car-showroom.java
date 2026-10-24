import java.util.*;
import java.io.*;
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static class Node{
        int position;
        int level;
        public Node(int position, int level){
            this.position = position;
            this.level = level;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
        }
        int[] wanted = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++){
            wanted[i] = Integer.parseInt(st.nextToken());
        }
        int[] visitor = new int[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        for(int i = 0; i<k; i++){
            int target = wanted[i];
            boolean[] visited = new boolean[n+1];
            visited[target] = true;
            
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(target, 0));
            while(!q.isEmpty()){
                Node now = q.poll();
                visitor[now.position] += 1;
                distance[now.position] = Math.max(now.level, distance[now.position]);
                List<Integer> linked = graph.get(now.position);

                for(int next : linked){
                    if(visited[next]) continue;
                    q.offer(new Node(next, now.level+1));
                    visited[next] = true;
                }
            }
        }
        int answer = 123456;
        for(int i = 1; i<=n; i++){
            if(visitor[i] == k){
                answer = Math.min(answer, distance[i]);
            }
        }
        System.out.printf("%d", answer == 123456?-1:answer);
    }
}