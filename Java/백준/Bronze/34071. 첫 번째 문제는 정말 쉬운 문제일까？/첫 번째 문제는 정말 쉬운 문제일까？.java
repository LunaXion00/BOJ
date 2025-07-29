import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int first=0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int dif = Integer.parseInt(st.nextToken());
            if(i==0) first = dif;
            min = Math.min(dif, min);
            max = Math.max(dif, max);

        }
        if(first == min) bw.write("ez");
        else if(first == max) bw.write("hard");
        else bw.write("?");
        bw.flush();
    }
}