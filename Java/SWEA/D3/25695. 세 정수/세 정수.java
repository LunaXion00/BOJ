import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int i = 0; i<T; i++){
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            if(x == y && y == z) System.out.println(x+" "+x+" "+x);
            else if(x != y && y != z && z != x) System.out.println("-1 -1 -1");
            else{
                if(x == y){
                    if(y < z) System.out.println("-1 -1 -1");
                    else System.out.println(z+" "+x+" "+z);
                }
                else if(y == z){
                    if(y < x) System.out.println("-1 -1 -1");
                    else System.out.println(x+" "+x+" "+y);
                }
                else if(z == x){
                    if(z < y) System.out.println("-1 -1 -1");
                    else System.out.println(x+" "+y+" "+y);
                }
            }
        }
    }
}