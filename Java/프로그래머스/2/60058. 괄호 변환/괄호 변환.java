import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(checkValid(p)) answer = p;
        else{
            answer = simulate(p);
        }
        return answer;
    }
    private boolean checkValid(String p){
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < p.length()){
            char now = p.charAt(index);
            if(now == '(') stack.push(now);
            else{
                if(stack.isEmpty()) return false; 
                stack.pop();
            }
            index++;
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    private String simulate(String s){
        if(s.length() == 0) return "";
        String[] sp = splitString(s);
        String u = sp[0];
        String v = sp[1];
        if(checkValid(u)){
            return u+simulate(v);
        }
        else{
            return "("+simulate(v)+")"+make(u);
        }
    }
    private String[] splitString(String s){
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='(') count1++;
            else count2++;
            if(count1 == count2 && count1 != 0) return new String[]{s.substring(0, i+1), s.substring(i+1)};
        }
        return new String[]{s, ""};
    }
    private String make(String s){
        StringBuilder sb = new StringBuilder();
        if(s.length()==2) return "";
        for(int i = 1; i<s.length()-1; i++){
            if(s.charAt(i)=='(') sb.append(")");
            else if(s.charAt(i)==')')sb.append("(");
        }
        return sb.toString();
    }
}