import java.util.Scanner;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int i = 0; i<T; i++){
            int N = sc.nextInt(), K = sc.nextInt();
            String s = sc.next();
            List<Integer> list = new ArrayList<>();
            int len = N/4;
            for(int j = 0; j<len; j++){
                String r = rotate(s, j);
                for(int k = 0; k<4; k++){
                    int password = Integer.parseInt(r.substring(k*len, k*len+len), 16);
                    if(!list.contains(password)) list.add(password);
                }
            }
            list.sort(Collections.reverseOrder());
            System.out.println("#"+(i+1)+" "+list.get(K-1));
        }
    }
    private static String rotate(String s, int index){
        return s.substring(index) + s.substring(0, index);
    }
}