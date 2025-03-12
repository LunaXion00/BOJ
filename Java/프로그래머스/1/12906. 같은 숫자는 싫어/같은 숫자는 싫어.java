import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<>();
        int last = -1;
        for(int i =0; i<arr.length; i++){
            if(arr[i]==last) continue;
            q.add(arr[i]);
            last = arr[i];
        }
        return q.stream().mapToInt(i->i).toArray();
    }
}