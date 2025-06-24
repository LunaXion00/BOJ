import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class SegTree{
        private boolean[] tree;
        private int size;
        public SegTree(int size){
            this.size = size;
            tree = new boolean[2*size];
            Arrays.fill(tree, true);
        }
        public void update(int i, boolean val){
            int idx = (i-1)|size;
            tree[idx] = val;
            for(idx >>= 1; idx > 0 ; idx >>= 1){
                tree[idx] = tree[idx << 1] || tree[(idx << 1) | 1];
            }
        }
        public int getNext(int start) {
            int i = (start - 1) | size;
            while (i > 0 && !tree[i]) {
                if (i == 1) {
                    i = 0;
                    break;
                }
                i = (i + 1) >> 1;
            }
            if (i <= 0) return size + 1;
            while (i < size) {
                i = (i << 1) | (tree[i << 1] ? 0 : 1);
            }
            return i - size + 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        int[] v = new int[N+1];
        SegTree segTree = new SegTree(1 << 20);
        for(int i = 1; i<=Q; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
            if(t == 1){
                int p = segTree.getNext(e);
                if(p>N) bw.write("-1\n");
                else{
                    bw.write(p+"\n");
                    v[p] = i;
                    segTree.update(p, false);
                }
            } else{
                if(v[e] == 0) bw.write("-1\n");
                else{
                    bw.write(v[e]+"\n");
                    v[e] = 0;
                    segTree.update(e, true);
                }
            }
        }
        bw.flush();
    }
}