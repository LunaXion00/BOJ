import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
class Main {
    static boolean[] isPrime;
    static List<Integer> prime = new ArrayList<>();
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        isPrime = new boolean[(int)Math.sqrt(B)+1];
        Arrays.fill(isPrime, true);
        make_prime();
        int answer = 0;
        for(int i = A; i<=B; i++){
            int count = factorization(i);
            if(prime.contains(count)) answer++;
        }
        System.out.print(answer);
    }
    private static void make_prime(){
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i<isPrime.length; i++){
            if(isPrime[i]) prime.add(i);
            for(int j= i*2; j<isPrime.length; j+=i){
                isPrime[j] = false;
            }
        }
    }
    private static int factorization(int num){
        int count = 0;
        int index = 0;
        while(!prime.contains(num)){
            if(index >= prime.size()) break;
            int div = prime.get(index);
            if(div > Math.sqrt(num)) break;
            if(num % div == 0) {
                num /= div;
                count++;
            }
            else index++;
        }
        return count+1;
    }
}