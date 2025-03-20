import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> need = new ArrayList<>();
        List<Integer> extra = new ArrayList<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int borrow = 0;
        for(int i : reserve) extra.add(i);
        for(int i : lost){
            if(extra.contains(i)){
                extra.remove(Integer.valueOf(i));
            }
            else {
                need.add(i);
            }
        }
        for(int i : need){
            if(extra.contains(i-1)){
                borrow++;
                extra.remove(Integer.valueOf(i-1));
                continue;
            }
            if(extra.contains(i+1)){
                borrow++;
                extra.remove(Integer.valueOf(i+1));
                continue;
            }
        }
        return n-need.size()+borrow;
    }
}