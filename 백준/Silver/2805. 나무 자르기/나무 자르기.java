import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long min = 0, max = 0;

        for(int i = 0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > max) max = trees[i];
        }
        while(min < max){
            long mid = (min+max)/2;
            long sum = 0;
            for(int tree : trees){
                if(tree > mid) sum += tree-mid;
            }
            if(sum < M) max = mid;
            else min = mid+1;
        }
        System.out.println(min-1);
    }
}