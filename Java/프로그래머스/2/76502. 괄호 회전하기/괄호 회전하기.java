import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            if(check(s.substring(i)+s.substring(0, i))) answer++;
        }
        return answer;
    }
    private boolean check(String s){
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0)==']'||s.charAt(0)=='}'||s.charAt(0)==')'||s.length()==1) return false;
        stack.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            char c = s.charAt(i);
            if(!(c==']'||c=='}'||c==')')) stack.add(c);
            else{
                if(stack.isEmpty()) return false;
                char recent = stack.pop();
                if(c == ')' && recent != '(') return false;
                if(c == '}' && recent != '{') return false;
                if(c == ']' && recent != '[') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}