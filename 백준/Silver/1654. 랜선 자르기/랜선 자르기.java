import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int[] lines = new int[K];
        long min = 0, max = 0;
        for(int i = 0; i<K; i++){
            lines[i] = Integer.parseInt(br.readLine());
            if(max < lines[i]) max = lines[i];
        }
        max++;
        while(min < max){
            long sum = 0;
            long mid = (max + min) / 2;
            for(int line : lines){
                sum += line/mid;
            }
            if(sum >= N) min = mid+1;
            else max = mid;
        }
        System.out.println(min-1);
    }
}