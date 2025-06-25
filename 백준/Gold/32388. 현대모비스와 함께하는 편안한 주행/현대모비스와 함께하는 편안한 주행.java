import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Point[] graph = new Point[N+2];
        graph[0] = new Point(0, 0);
        graph[N+1] = new Point(a, b);

        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        double[] cost = new double[N+2];
        Arrays.fill(cost, Double.MAX_VALUE);
        cost[0] = 0;

        List<Integer> available = new ArrayList<>();
        for(int i = 0; i<N+2; i++) available.add(i);

        while(true){
            int p = -1;
            for(int node:available) if(p==-1 || cost[node] < cost[p]) p = node;

            if(p == N+1) break;
            available.remove(Integer.valueOf(p));
            for(int node : available){
                double newCost = cost[p] + getCost(p, node, graph, N);
                if(newCost<cost[node]) cost[node] = newCost;
            }
        }
        System.out.printf("%.9f", cost[N+1]);
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static double getCost(int i, int j, Point[] graph, int N){
        double dx = graph[i].x - graph[j].x;
        double dy = graph[i].y - graph[j].y;

        double dist = Math.hypot(dx, dy);
        if(i>= 1 && i <= N) dist -= 1;
        if(j>= 1 && j <= N) dist -= 1;
        if(dist < 0) dist = 0;

        return dist;
    }
}