import java.io.*;
import java.util.*;

public class Solution {
    static final double error = 1e-12;  // 오차 범위

    public static class Mag{
        double x;
        double m;
        public Mag(double x, double m) {
            this.x = x;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            List<Mag> mags = new ArrayList<>();

            double[] x = new double[N];
            double[] m = new double[N];

            for(int i = 0; i < N; i++) x[i] = sc.nextDouble();
            for(int i = 0; i < N; i++) m[i] = sc.nextDouble();

            for(int i = 0; i < N; i++) {
                mags.add(new Mag(x[i], m[i]));
            }

            mags.sort((o1, o2) -> Double.compare(o1.x, o2.x));
            

            // 각 구간마다 균형점 찾기
            for(int i = 0; i < N - 1; i++){
                double equilibrium = findEquilibrium(mags, i, N);
                System.out.println(String.format("#%d %.10f", (t+1), equilibrium));
            }
        }
    }

    static double findEquilibrium(List<Mag> mags, int idx, int N) {
        double start = mags.get(idx).x;
        double end = mags.get(idx + 1).x;
        
        while(end - start > error) {
            double mid = (start + end) / 2.0;
            double left = 0, right = 0;

            for(int j = 0; j <= idx; j++){
                double dist = mid - mags.get(j).x;
                left += mags.get(j).m / (dist * dist);
            }

            for(int j = idx + 1; j < N; j++){
                double dist = mags.get(j).x - mid;
                right += mags.get(j).m / (dist * dist);
            }

            if(left > right){
                start = mid;
            } else {
                end = mid;
            }
        }
        return (start + end) / 2.0;
    }
}
