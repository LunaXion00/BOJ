import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int[] check = new int[M];
        int answer = 0;
        for(int i = 1; i<M-1;i++){
            if(s.charAt(i) == 'O' && s.charAt(i+1) == 'I') check[i+1] = check[i-1]+1;
            if(check[i+1] >= N && s.charAt(i-2*N+1) == 'I') answer++;
        }
        System.out.print(answer);
    }
}