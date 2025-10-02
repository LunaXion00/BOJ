import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int end_time = prices.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<prices.length; i++){
            while(!st.isEmpty() && prices[i] < prices[st.peek()]){
                int index = st.pop();
                answer[index] = i- index;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index = st.pop();
            answer[index] = end_time - index-1;
        }
        return answer;
    }
}