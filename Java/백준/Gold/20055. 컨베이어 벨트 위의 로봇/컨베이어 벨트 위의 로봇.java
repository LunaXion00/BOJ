import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Belt{
        int dur;
        boolean exist;
        public Belt(int dur, boolean exist){
            this.dur = dur;
            this.exist = exist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Belt[] belts = new Belt[2*N];
        for(int i = 0; i<2*N; i++){
            belts[i] = new Belt(Integer.parseInt(st.nextToken()), false);
        }
        int level = 0;
        int head = 0;
        int tail = N-1;
        while(true){
            level++;
            head = (head-1+2*N)%(2*N);
            tail = (tail-1+2*N)%(2*N);
            if(belts[tail].exist) belts[tail].exist = false;
            for (int i = 1; i < N; i++) {
                int idx = (tail - i + 2 * N) % (2 * N);
                int next = (idx + 1) % (2 * N);
                if (belts[idx].exist && !belts[next].exist && belts[next].dur > 0) {
                    belts[idx].exist = false;
                    belts[next].exist = true;
                    belts[next].dur--;
                }
            }
            if (belts[tail].exist) belts[tail].exist = false;

            if (belts[head].dur > 0 && !belts[head].exist) {
                belts[head].exist = true;
                belts[head].dur--;
            }
            if(check(belts, K)) break;
        }
        System.out.println(level);
    }
    public static boolean check(Belt[] belts, int K){
        int flag = 0;
        for(Belt belt:belts) if(belt.dur==0) flag++;
        return flag>=K;
    }
}