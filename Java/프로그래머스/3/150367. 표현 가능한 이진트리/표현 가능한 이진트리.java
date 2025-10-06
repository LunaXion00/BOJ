import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for(long number:numbers){
            String s = Long.toBinaryString(number);
            s = convertToPBT(s);
            answer.add(check(s)?1:0);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
    public String convertToPBT(String s){
        int length = s.length();
        int cnt = 1;
        int nodecnt = 1;
        while(cnt<length){
            nodecnt *= 2;
            cnt += nodecnt;
        }
        int need = cnt - length;
        return "0".repeat(need)+s;
        
    }
    public static boolean check(String s){
        int length = s.length();
        if(length == 0) return true;
        int root = length/2;
        String left = s.substring(0, root);
        String right = s.substring(root+1);
        
        if(s.charAt(root) == '0') {
            return checkZero(left) && checkZero(right);
        } 
        return check(left) && check(right);
    }
    public static boolean checkZero(String s){
        if(s.contains("1")) return false;
        return true;
    }
}