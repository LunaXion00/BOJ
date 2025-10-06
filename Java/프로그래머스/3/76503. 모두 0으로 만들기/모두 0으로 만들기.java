import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] degree;
    static long[] long_a;
    static long answer;
    public long solution(int[] a, int[][] edges) {
        long_a = new long[a.length];
        graph = new ArrayList[a.length];
        long sum = 0;
        visited = new boolean[a.length];
        for(int i = 0; i<a.length; i++){
            sum += a[i];
            long_a[i] = a[i];
            graph[i] = new ArrayList<>();
        }
        if(sum != 0) return -1;
        
        degree = new int[a.length];
        for(int i = 0; i<edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        t_sort();
        return answer;
    }
    public static void t_sort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<degree.length; i++) {
            if(degree[i] == 1) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int i = 0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(!visited[next]){
                    degree[next]--;
                    long_a[next] += long_a[cur];
                    answer += Math.abs(long_a[cur]);
                    long_a[cur] = 0;
                    if(degree[next] == 1) q.offer(next);
                }
            }
        }
    }
}