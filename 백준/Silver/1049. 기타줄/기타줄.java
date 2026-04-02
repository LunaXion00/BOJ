import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int cheap6 = Integer.MAX_VALUE;
        int cheap1 = Integer.MAX_VALUE;
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int cost6 = Integer.parseInt(st.nextToken());
            int cost1 = Integer.parseInt(st.nextToken());
            if(cost6 > cost1*6) cost6 = cost1*6;
            if(cheap6 > cost6) cheap6 = cost6;
            if(cheap1 > cost1 ) cheap1 = cost1;
        }
        // 6개 단위로 사고 남은걸 1개로 채움 -> 딱 맞게 사는 경우
        // 6개 단위로 오버해도 걍 사는 경우.
        int answer = Math.min(N/6 * cheap6 + N%6 * cheap1, (N/6+1) * cheap6);
        System.out.println(answer);
    }
}