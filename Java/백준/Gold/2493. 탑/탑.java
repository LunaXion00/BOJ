import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Tower{
        int num;
        int height;
        public Tower(int num, int height){
            this.num = num;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Tower> tower = new Stack<>();
        int num = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int height = Integer.parseInt(st.nextToken());
            if(tower.isEmpty()) {
                bw.write("0 ");
                tower.push(new Tower(i+1, height));
            }
            else{
                while(true){
                    if(tower.isEmpty()){
                        bw.write("0 ");
                        tower.push(new Tower(i+1, height));
                        break;
                    }
                    Tower top = tower.peek();
                    if(top.height>height){
                        bw.write(top.num+" ");
                        tower.push(new Tower(i+1, height));
                        break;
                    }
                    else tower.pop();
                }
            }
        }
        bw.flush();
    }
}