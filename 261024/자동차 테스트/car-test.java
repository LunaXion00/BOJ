import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        List<Integer> car = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            car.add(Integer.parseInt(st.nextToken()));
        }
        
        int[] queries = new int[q];
        for(int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            queries[i] = Integer.parseInt(st.nextToken());
        }
        Collections.sort(car);
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i<n; i++){
            int count = i*(n-i-1);
            counts.put(car.get(i), count);
        }
        for(int i = 0; i<q; i++){
            System.out.println(counts.getOrDefault(queries[i], 0));
        }
    }
}