import java.util.*;
import java.io.*;
public class Main {
	static int[] dist;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for(int i = 0; i<N+1; i++) graph.add(new ArrayList<>());
		dist = new int[N+1];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
		}
		dijkstra(X);
		List<Integer> answer = new ArrayList<>();
		for(int i = 1; i<=N; i++) {
			if(dist[i] == K) answer.add(i);
		}
		if(answer.size() == 0) System.out.println(-1);
		else {
			answer.sort(Comparator.naturalOrder());
			for(int ans: answer) {
				System.out.println(ans);
			}
		}
	}
	static private void dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : graph.get(cur)) {
				int d = dist[cur]+1;
				if(d > dist[next]) continue;
				dist[next] = d;
				q.offer(next);
			}
		}
	}
}
