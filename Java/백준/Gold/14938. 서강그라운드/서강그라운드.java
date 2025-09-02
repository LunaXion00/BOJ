import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int index;
        int distance;
        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }
    }
    static int[] items;
    static int[] distance;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        int answer = 0;
        items = new int[n];
        distance = new int[n];
        graph = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken()), p2 = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            graph.get(p1-1).add(new Node(p2-1, w));
            graph.get(p2-1).add(new Node(p1-1, w));
        }
        for(int i = 0; i<n; i++){
            int start = i;
            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra(start);

            int sum = 0;
            for(int j = 0; j<n; j++){
                if(distance[j] == Integer.MAX_VALUE) continue;
                if(distance[j]<=m) sum+= items[j];
            }
            answer = Math.max(sum, answer);
        }
        System.out.print(answer);
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;
            if(distance[now]<dist) continue;
            for(int i = 0; i<graph.get(now).size(); i++){
                int cost = distance[now]+graph.get(now).get(i).distance;
                if(cost<distance[graph.get(now).get(i).index]){
                    distance[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}