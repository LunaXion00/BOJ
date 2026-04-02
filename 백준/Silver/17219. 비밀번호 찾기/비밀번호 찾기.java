import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            bw.write(map.get(st.nextToken())+"\n");
        }
        bw.flush();
    }
}