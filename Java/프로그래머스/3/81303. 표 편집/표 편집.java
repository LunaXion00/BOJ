import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        int size = n;
        int pointer = k;
        for(String command:cmd){
            char c = command.charAt(0);
            if(c=='U') pointer -= Integer.parseInt(command.substring(2));
            else if(c == 'D') pointer += Integer.parseInt(command.substring(2));
            else if(c == 'C'){
                deleted.add(pointer);
                size--;
                if(pointer == size) pointer--;
            }
            else if(c == 'Z'){
                if(deleted.pop()<= pointer) pointer++;
                size++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<size; i++) sb.append("O");
        while(!deleted.isEmpty()) sb.insert(deleted.pop().intValue(), "X");

        return sb.toString();
    }
}