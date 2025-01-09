import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int h,w,n,m, c, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = (h-1)/(n+1)+1;
        r = (w-1)/(m+1)+1;
        System.out.println(c*r);
    }
}
