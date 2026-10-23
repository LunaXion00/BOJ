import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        if(s.length() % 2 == 1) System.out.println("No");
        else{
            int minopen = 0;
            int maxopen = 0;
            boolean flag = false;
            for(int i = 0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(') {
                    minopen++;
                    maxopen++;
                }
                else if(c == ')') {
                    minopen = Math.max(0, minopen - 1);
                    maxopen--;
                }
                else{
                    minopen = Math.max(0, minopen - 1);
                    maxopen++;
                }
                if(maxopen < 0) flag = true;
            }
            if(minopen != 0) flag = true;
            System.out.printf("%s", flag?"No":"Yes");
        }
    }
}