import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(n == 1 || (n==2 && (arr[0] != arr[1])))
            bw.write("A");
        else if(n ==2)
            {
                bw.write(arr[0]+"");
            }
        else{
            int a, b;
            if (arr[1] == arr[0]){
                // 같은 값을 넣으면 그 다음에도 같은 값이 나올 것(동일한 수식을 사용하니까) 물론, a = -1이고 b = 2x일 수도 있지만 크게 상관 없음)
                a = 1;
                b = 0;
            }
            else{
                a = (arr[2]-arr[1])/(arr[1]-arr[0]);
                b = arr[1] - arr[0]*a;
            }
            for (int i = 0; i<n-1; i++){
                if (arr[i]*a+b != arr[i+1]){
                    bw.write("B");
                    bw.flush();
                    return;
                }
            }
            bw.write((arr[n-1]*a+b)+"");
        }
        bw.flush();
    }
}