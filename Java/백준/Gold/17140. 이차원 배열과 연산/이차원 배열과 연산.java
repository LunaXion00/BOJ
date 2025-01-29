import java.io.*;
import java.util.*;

public class Main {
    static int r,c,k;
    static int[][] map;
    static int r_len, c_len;
    public static class Node implements Comparable<Node>{
        int num;
        int cnt;
        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node o){
            if(this.cnt == o.cnt) return this.num-o.num;
            return this.cnt-o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[101][101];

        for(int i = 0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        r_len = 3;
        c_len = 3;
        int limit = 0;
        int ans = -1;
        while(limit <= 100){
            if(map[r-1][c-1] == k){
                ans = limit;
                break;
            }
            if(r_len >= c_len) row_cal();
            else col_cal();
            limit++;
        }
        System.out.print(ans);
    }
    public static void row_cal(){
        int[][] map_copy = new int[101][101];
        int col = 0;
        for(int i = 0;i<r_len;i++){
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int j=0; j<c_len; j++){
                if(map[i][j]== 0) continue;
                if(hash.containsKey(map[i][j])){
                    hash.put(map[i][j], hash.get(map[i][j])+1);
                }
                else{
                    hash.put(map[i][j], 1);
                }
            }
            ArrayList<Node> nodes = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry: hash.entrySet()){
                nodes.add(new Node(entry.getKey(), entry.getValue()));
            }
            col = Math.max(col, nodes.size()*2);
            Collections.sort(nodes);
            for(int j = 0; j<nodes.size(); j++){
                if(j>=50) break;
                Node node = nodes.get(j);
                map_copy[i][2*j] = node.num;
                map_copy[i][2*j+1] = node.cnt;
            }
        }
        c_len = Math.min(99, col);
        map = map_copy;
    }
    public static void col_cal(){
        int[][] map_copy = new int[101][101];
        int row = 0;
        for(int i = 0;i<c_len;i++){
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int j=0; j<r_len; j++){
                if(map[j][i]== 0) continue;
                if(hash.containsKey(map[j][i])){
                    hash.put(map[j][i], hash.get(map[j][i])+1);
                }
                else{
                    hash.put(map[j][i], 1);
                }
            }
            ArrayList<Node> nodes = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry: hash.entrySet()){
                nodes.add(new Node(entry.getKey(), entry.getValue()));
            }
            row = Math.max(row, nodes.size()*2);
            Collections.sort(nodes);
            for(int j = 0; j<nodes.size(); j++){
                if(j>=50) break;
                Node node = nodes.get(j);
                map_copy[2*j][i] = node.num;
                map_copy[2*j+1][i] = node.cnt;
            }
        }
        r_len = Math.min(99, row);
        map = map_copy;
    }
}