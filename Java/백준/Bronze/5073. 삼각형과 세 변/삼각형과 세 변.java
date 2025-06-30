import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int[] side = new int[3];
        while(true){
            side[0] = Integer.parseInt(st.nextToken());
            side[1] = Integer.parseInt(st.nextToken());
            side[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(side);
            if(side[0] == 0) break;
            if(side[0] == side[1] && side[1] == side[2]) bw.write("Equilateral\n");
            else if(side[0] + side[1] <= side[2]) bw.write("Invalid\n");
            else if(side[0] != side[1] && side[1] != side[2] && side[2] != side[0]) bw.write("Scalene\n");
            else bw.write("Isosceles\n");
            st = new StringTokenizer(br.readLine());
        }
        bw.flush();
    }
}