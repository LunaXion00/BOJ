import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int last = people.length - 1;
        Arrays.sort(people);
        while(start<=last){
            if(people[start] + people[last] <= limit){
                start++;
                last--;
            }
            else{
                last--;
            }
            answer++;   
        }
        
        return answer;
    }
}