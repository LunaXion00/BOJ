import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=N; i++) q.offer(i);
        st = new StringTokenizer(br.readLine());
        int[] target = new int[M];
        for(int i = 0; i<M; i++) target[i] = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i = 0; i<M; i++){
            int count = 0;
            while(q.peek() != target[i]){
                int now = q.poll();
                q.offer(now);
                count++;
            }
            sum += Math.min(q.size() - count, count);
            q.poll();
        }
        System.out.println(sum);
    }
}