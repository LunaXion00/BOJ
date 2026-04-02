import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] nums = new String[N];
        for(int i = 0; i<N; i++) nums[i] = br.readLine();
        int M = nums[0].length();
        int len = 1;

        outer:for(; len<M; len++) {
            Set<String> set = new HashSet<>();
            for (String s : nums) {
                String sub = s.substring(M - len);
                if (set.contains(sub)) continue outer;
                set.add(sub);
            }
            break;
        }
        System.out.println(len);
    }
}