import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] hole = new int[N];
        for(int i = 0; i<N; i++){
            hole[i] = Integer.parseInt(st.nextToken());
        }
        int min = 0;
        int max = hole[N-1]+1;
        int answer = max;
        if(K>= N) System.out.println(1);

        else{
            while(min <= max){
            int center = (min+max)/2;
            int start = hole[0];
            int remain = K-1;
            int index = 0;
            while(index < N){
                if(start + center - 1 >= hole[index]) index++;
                else{
                    remain -= 1;
                    start = hole[index++];
                }
            }
            if(remain < 0){
                // System.out.printf("%d to %d short: %d\n", min, max, center);
                min = center+1;
            } else if(remain >= 0){
                answer = Math.min(answer, center);
                // System.out.printf("%d to %d long: %d\n", min, max, answer);
                max = center-1;
            } 
        }
        System.out.println(answer);
        }
    }
}