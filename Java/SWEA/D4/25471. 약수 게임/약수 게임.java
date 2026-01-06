import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			long N = sc.nextLong();
            if(N%2 == 1) System.out.println("B");
            else{
                int flag = checkPow(N);
                if(flag == -1) System.out.println("A");
                else if(flag%2 == 0) System.out.println("A");
                else System.out.println("B");
            }
		}
	}
    private static int checkPow(long N){
        int count = 0;
        while(N > 1){
            if(N % 2 == 1) return -1;
            else {
                N /= 2;
                count++;
            }
        }
        return count;
    }
}