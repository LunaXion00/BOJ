import java.io.*;
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
        int temp = 0;
//        새로 추가한 index가 문제를 발생하는지 파악. 0~index까지를 다 더해주고, 하나씩 1~index, 2~index, ... 의 sum을 sign과 비교.
        for(int i =0; i<= idx; i++) temp += result[i];
        for(int i = 0; i<=idx; i++){
            if(sign[i][idx] != (temp == 0? '0' : (temp > 0?'+':'-'))) return false;
            temp -= result[i];
        }
        return true;
    }
}
