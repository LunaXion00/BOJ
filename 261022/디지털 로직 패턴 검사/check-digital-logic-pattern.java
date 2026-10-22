import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<Long, Integer> map = new HashMap<>();
        long num = 0;
        for(int i = 0; i<K; i++){
            num = num* 2 + Integer.parseInt(s.charAt(i)+"");
        }
        map.put(num, 1);
        for(int i = K; i<s.length(); i++){
            num = num*2 + Integer.parseInt(s.charAt(i)+"") - Integer.parseInt(s.charAt(i-K)+"") * (1L << K);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        boolean flag = false;
        for(Long key: map.keySet()){
            if(map.get(key)>= M) flag = true;
        }
        System.out.printf("%d", flag?1:0);
    }
}