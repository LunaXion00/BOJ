import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static class Node{
        int e, w;
        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    static List<List<Node>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=N; i++) tree.add(new ArrayList<>());
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree.get(s).add(new Node(e, w));
            tree.get(e).add(new Node(s, w));
        }
        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(bfs(s, e));
        }
    }
    public static int bfs(int s, int e){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0));
        boolean[] visited = new boolean[tree.size()];
        visited[s] = true;
        while(!q.isEmpty()){
            Node current = q.poll();
            if(current.e == e){
                return current.w;
            }
            for(Node node:tree.get(current.e)){
                if(!visited[node.e]){
                    visited[node.e]=true;
                    q.add(new Node(node.e, node.w+current.w));
                }
            }
        }
        return -1;
    }
}