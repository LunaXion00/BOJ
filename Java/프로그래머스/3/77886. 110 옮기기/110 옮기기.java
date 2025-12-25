import java.util.*;
class Solution {
    static int count;
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i<s.length; i++){
            count = 0;
            String trans = remove110(s[i]);
            String result = append110(trans);
            answer[i] = result;
        }
        return answer;
    }
    private String remove110(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.size() < 2) stack.push(c);
            else{
                char a = stack.pop();
                char b = stack.pop();
                if(!(c == '0' && a == '1' && b == '1')) {
                    stack.add(b);
                    stack.add(a);
                    stack.add(c);
                } else count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    private String append110(String trans){
        if(count == 0) return trans;
        String ap = "110".repeat(count);
        int index = trans.lastIndexOf('0');
        if(index == -1) {
            return ap+trans;
        }
        else{
            String left = trans.substring(0, index + 1);
            String right = trans.substring(index + 1);
            return left + ap + right;
        }
    }
}