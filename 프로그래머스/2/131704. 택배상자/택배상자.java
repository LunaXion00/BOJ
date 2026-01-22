import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i<=order.length; i++){
            // 메인 컨테이너 벨트에 있는 게 원하는 거라면 그대로 추가.
            if(order[answer] == (i)) answer++;
            else {
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() == order[answer]){
                stack.pop();
                answer++;
            }
            
        }
        while(!stack.isEmpty()){
            if(order[answer] == stack.pop()) answer++;
            else break;
        }
        return answer;
    }
}