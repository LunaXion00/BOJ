import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int x, y, d1, d2;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int x = 1; x<=N; x++){
            for(int y = 1; y<=N; y++){
                for(int d1 = 1; d1<=N; d1++){
                    if(y-d1 <1) break;
                    for(int d2 = 1; d2<=N; d2++){
                        if(x+d1+d2 >N) break;
                        if(y+d2 > N) break;
                        simulate(x,y,d1,d2);
                    }
                }
            }
        }
        System.out.print(ans);
    }

    public static void simulate(int x, int y, int d1, int d2){
        int[][] area = new int[N+1][N+1];
        for(int i = 0; i<=d1; i++){
            area[x+i][y-i] = 5;
            area[x+d2+i][y+d2-i] = 5;
        }
        for(int i = 0; i<=d2; i++){
            area[x+i][y+i] = 5;
            area[x+d1+i][y-d1+i] = 5;
        }
        boolean start = false;
        for(int i= x+1; i<x+d1+d2; i++){
            for(int j = 1; j<=N; j++){
                if(start){
                    if(area[i][j] == 5){
                        start = false;
                        break;
                    }
                    area[i][j] = 5;
                }
                if(area[i][j] == 5) start = true;
            }
        }
        for(int i = 1; i<x+d1; i++){
            for(int j = 1; j<=y; j++){
                if(area[i][j] == 5) break;
                area[i][j] = 1;
            }
        }
        for(int i = 1; i<=x+d2; i++){
            for(int j = y+1; j<=N; j++){
                if(area[i][j] == 5) continue;
                area[i][j] = 2;
            }
        }
        for(int i = x+d1; i<=N; i++){
            for(int j = 1; j<y-d1+d2; j++){
                if(area[i][j] == 5) break;
                area[i][j] = 3;
            }
        }
        for(int i = x+d2+1; i<=N; i++){
            for(int j = y-d1+d2; j<=N; j++){
                if(area[i][j] == 5) continue;
                area[i][j] = 4;
            }
        }
        calc(area);
    }

    public static void calc(int[][] area){
        int[] people = new int[5];
        for(int i = 1; i<=N; i++) {
            for (int j = 1; j <= N; j++) {
                people[area[i][j]-1] += map[i][j];
            }
        }
        Arrays.sort(people);
        ans = Math.min(ans, people[4]-people[0]);
    }
}
