import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int sqrt = (int)Math.sqrt(max);
        boolean[] notDiv = new boolean[(int)(max-min+1)];
        for(long i = 2; i<= sqrt; i++){
            long square = i*i;
            long q;
            if(min%square == 0) q = min/square;
            else q = min/square+1;

            for(long j = q; j*square <= max; j++){
                notDiv[(int)(j*square-min)] = true;
            }

        }
        int count = 0;
        for(int i = 0; i<notDiv.length; i++) if(!notDiv[i]) count++;
        bw.write(count+"");
        bw.flush();
    }
}