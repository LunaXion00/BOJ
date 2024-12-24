import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        for(int i = 2; i<=n; i++) isPrime[i] = true;
        for(int i = 2; i<=n; i++){
            if(isPrime[i]){
                list.add(i);
                for(int j = i+i; j<=n; j += i) isPrime[j] = false;
            }
        }
        int start = 0, end = 0;
        int sum = 0;
        int count = 0;
        while(start <= end && start < list.size()){
            if(sum < n && end < list.size()) sum += list.get(end++);
            else{
                if(sum == n) count++;
                sum -= list.get(start++);
            }
        }
        bw.write(count+"");
        bw.flush();
    }
}