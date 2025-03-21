import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0, end = 0;
        while(start<=end){
            if(arr[end]-arr[start] < M){
                end++;
                if(end >= N) break;
            } else if(arr[end] - arr[start] > M){
                answer = Math.min(answer, arr[end]-arr[start++]);
            } else{
                System.out.println(M);
                return;
            }
        }
        System.out.println(answer);
    }

}