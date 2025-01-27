import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String line = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String bomb = st.nextToken();
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<line.length(); i++){
            stack.push(line.charAt(i));
            if(stack.size() >= bomb.length()){
                boolean flag = true;
                for(int j = 0; j<bomb.length();j++){
                    if(stack.get(stack.size()-bomb.length()+j)!= bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0; j<bomb.length(); j++){
                        stack.pop();
                    }
                }
            }
        }
        for(char ch: stack) sb.append(ch);
        System.out.print(sb.length()>0?sb.toString():"FRULA");
    }
}