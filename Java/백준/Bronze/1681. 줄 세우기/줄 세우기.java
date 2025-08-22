import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int cnt = 0;
        for(int i = 0; i<T; i++){
            while(Integer.toString(++cnt).contains(L)) ;
        }
        System.out.println(cnt);
    }
}