import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int test = 0; test<t; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] time = new int[n+1];
            int[] indegree = new int[n+1];
            ArrayList<Integer>[] node = new ArrayList[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<n+1;i++){
                time[i] = Integer.parseInt(st.nextToken());
                node[i] = new ArrayList<>();
            }
            for(int i = 0;  i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                node[a].add(b);
                indegree[b]++;
            }
            st = new StringTokenizer((br.readLine()));
            int w = Integer.parseInt(st.nextToken());
            int[] cost = new int[n+1];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i<indegree.length; i++){
                if(indegree[i] == 0){
                    cost[i] = time[i];
                    q.offer(i);
                }
            }
            while(!q.isEmpty()){
                int current = q.poll();

                for(int i = 0; i<node[current].size(); i++){
                    int next = node[current].get(i);
                    cost[next] = Math.max(cost[current] + time[next], cost[next]);
                    indegree[next]--;
                    if(indegree[next] == 0) q.offer(next);
                }
            }
            System.out.println(cost[w]);
        }
    }
}