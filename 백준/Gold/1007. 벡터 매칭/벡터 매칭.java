import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
class Main {
    static boolean[] start;
    static int N;
    static int[][] points;
    static double sum;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            sum = Double.MAX_VALUE;
            points = new int[N][2];
            start = new boolean[N];
            for(int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                points[j][0] = Integer.parseInt(st.nextToken());
                points[j][1] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            System.out.println(sum);
        }
    }
    static void dfs(int index, int count){
        if(index == N) return;
        if(count == N/2) {
            calculate();
            return;
        }
        start[index] = true;
        dfs(index+1, count+1);
        start[index] = false;
        dfs(index+1, count);
    }
    static void calculate(){
        int x = 0, y = 0;
        for(int i = 0; i<N; i++){
            if(start[i]) {
                x += points[i][0];
                y += points[i][1];
            } else{
                x -= points[i][0];
                y -= points[i][1];
            }
        }
        sum = Math.min(sum, Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
    }
}