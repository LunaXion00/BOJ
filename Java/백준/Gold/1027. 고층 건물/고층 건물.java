import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        building = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) building[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i = 0; i<N; i++) ans = Math.max(ans, solve(i));

        System.out.print(ans);
    }
    static int solve(int current){
        int cnt = 0;
        double angle = 0;

        for(int i = current-1; i>=0; i--){
            double degree = (double) (building[current]-building[i])/(current-i);
            if(i==current-1 || angle > degree) {
                angle = degree;
                cnt++;
            }
        }
        for(int i = current+1; i<N; i++){
            double degree = (double)(building[current]-building[i])/(current-i);
            if(i==current+1 || angle < degree){
                angle = degree;
                cnt++;
            }
        }
        return cnt;
    }
}