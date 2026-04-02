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
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++) sb.append("IO");
        sb.append("I");
        String find = sb.toString();
        int answer = 0;
        for(int i = 0; i<M-find.length()+1; i++){
            if(s.substring(i, i+find.length()).equals(find)) answer++;
        }
        System.out.println(answer);
    }
}