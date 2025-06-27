import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        List<Integer> remainders = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = n-2; i>=0; i--) {
            int diff = nums[i+1]-nums[i];
            if(diff > 0) remainders.add(diff);
        }
        if(remainders.size() == 1) {
            System.out.println(remainders.get(0));
            return;
        }
        int d = GCD(remainders.get(0), remainders.get(1));
        for(int i = 2; i<remainders.size(); i++){
            d = GCD(d, remainders.get(i));
        }
        System.out.println(d);
    }
    static int GCD(int N, int M){
        int n = N, m = M;
        while(true){
            int r = n % m;
            if(r == 0) return m;
            n = m;
            m = r;
        }
    }
}