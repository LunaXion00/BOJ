import java.io.*;
import java.util.*;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] fruits = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) fruits[i] = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int answer = 0;
        for(; end < N; end++){
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]);
                start++;
            }
            answer = Math.max(answer, end - start + 1);
        }
        System.out.print(answer);
    }
}