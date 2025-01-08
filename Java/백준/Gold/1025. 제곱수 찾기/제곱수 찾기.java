import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static String[] arr;
    static int[][] num;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n][m];
        arr = new String[n+1];
        for(int i =0; i<n; i++){
            arr[i] = br.readLine();
            for(int j = 0; j<m;j++){
                num[i][j] = arr[i].charAt(j)-'0';
            }
        }
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++) brute(i,j);
        }
        System.out.println(ans);
    }
    public static void brute(int col, int row){
        for(int i = -n; i<n; i++){
            for(int j = -m; j<m; j++){
                if(i == 0 && j==0) continue;
                int c = col;
                int r = row;
                String num_str = "";
                while(0<=c && c<n && 0<=r && r<m){
                    num_str+=arr[c].charAt(r);
                    int num = Integer.parseInt(num_str);
                    int root = (int)Math.sqrt(num);;
                    if(num == Math.pow(root, 2)) ans = Math.max(num, ans);
                    c += i;
                    r += j;
                }
            }
        }
    }
}
