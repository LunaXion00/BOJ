import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        String[] nums = s.split("0");
        for(String num : nums){
            if(num.equals("")) continue;
            long trans = Long.parseLong(num);
            if(check(trans)) answer++;
        }
        return answer;
    }
    private static boolean check(long num){
        if(num == 1) return false;
        if(num == 2) return true;
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}