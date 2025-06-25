import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] fac = new long[n + 1];
        long[] inv = new long[n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++) fac[i] = (fac[i - 1] * i) % mod;
        inv[n] = pow(fac[n], mod - 2, mod);

        for (int i = n; i >= 1; i--) inv[i - 1] = (inv[i] * i) % mod;

        long res = fac[n];
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            long power = pow(2, x - 1, mod);
            res = (res * power) % mod;
            res = (res * inv[x]) % mod;
        }

        System.out.println(res);
    }

    private static long pow(long base, int exp, int mod) {
        if (exp < 0) return pow(base, mod - 2, mod);
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

}