import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] result;
    static char[][] sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sign = new char[n][n];
        result = new int[n];
        String str = br.readLine();
        int index = 0;
        for(int i = 0; i<n; i++) for(int j = i;j<n;j++) sign[i][j] = str.charAt(index++);
        dfs(0);
    }
    public static void dfs(int index){
        if (index == n) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.exit(0); // 프로그램 종료
        }
        for(int i =-10; i<=10; i++){
            result[index] = i;
            if(check(index)) {
                dfs(index+1);
            }
        }
    }
    public static boolean check(int idx){
        for (int i = 0; i <= idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += result[j];
                if (sign[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
