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
        int answer = 1;
        int start = s.indexOf(find);
        if(start == -1) answer = 0;
        else{
            while(start < M-find.length()+1){
                int end = start + find.length();
                if(end + 2 <= M && s.substring(end, end+2).equals("OI")) {
                    answer++;
                    start += 2;
                } else{
                    start = s.indexOf(find, start+1);
                    if(start == -1) break;
                    else answer++;
                }
            }
        }
        System.out.println(answer);
    }
}