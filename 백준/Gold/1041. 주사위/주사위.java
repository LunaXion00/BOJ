import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        st = new StringTokenizer(br.readLine());
        long min_3 = 0, min_2 = Integer.MAX_VALUE, min_1 = Integer.MAX_VALUE;
        long count_3 = 4, count_2 = 8*(N-2)+4, count_1 = 5*(N-2)*(N-2)+4*(N-2);
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min_1 = Math.min(min_1, arr[i]);
        }
        if(N==1){
            Arrays.sort(arr);
            int sum = 0 ;
            for(int i = 0; i<5; i++) sum += arr[i];
            System.out.println(sum);
        }
        else{
            long sum = 0;
            sum += min_1 * count_1;
            for(int i = 0; i<6; i++){
                for(int j = i+1; j<6; j++){
                    if(j+i != 5){
                        min_2 = Math.min(min_2, arr[i]+arr[j]);
                    }
                }
            }
            sum += min_2 * count_2;
            for(int i = 0; i<3; i++) min_3 += Math.min(arr[i], arr[5-i]);
            sum += min_3 * count_3;
            System.out.println(sum);
        }
    }
}