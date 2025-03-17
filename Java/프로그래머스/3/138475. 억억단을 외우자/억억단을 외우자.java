import java.util.*;
class Solution {
    static class Point{
        int num;
        int cnt;
        Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    public int[] solution(int e, int[] starts) {
        List<Integer> answer = new ArrayList<>();
        Point[] dp = new Point[e+1];
        for(int i = 0; i<=e; i++) dp[i] = new Point(i, 0);
        for(int i = 1; i<=e; i++) {
            for(int j = 1; j<= e/i; j++) dp[i*j].cnt +=1;
        }
        Arrays.sort(dp, new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2){
                if(o1.cnt > o2.cnt) return -1;
                else if(o1.cnt < o2.cnt) return 1;
                else{
                    return o1.num-o2.num;
                }
            }
        });
        for(int s: starts){
            for(Point p:dp){
                if(p.num>=s) {
                    answer.add(p.num);
                    break;
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}