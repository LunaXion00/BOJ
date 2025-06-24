import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> counter = new HashMap<>();
        int max = -1;
        String answer = "";
        int n = Integer.parseInt(st.nextToken());
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            while(t-->0){
                String tag = st.nextToken();
                counter.put(tag, counter.getOrDefault(tag, 0)+1);
            }
        }
        for(String tag : counter.keySet()){
            int count = counter.get(tag);
            if(count > max){
                answer = tag;
                max = count;
            } else if(count == max) answer = "";
        }
        if(answer.equals("")) bw.write("-1");
        else bw.write(answer);
        bw.flush();
    }
}