import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int cursor = name.length() - 1;
        // 일단 각 자리에서 목표 알파벳으로 변경하는 횟수
        for(int i = 0; i<name.length(); i++) {
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A') next++;
            cursor = Math.min(cursor, i*2+(name.length()-next));
            cursor = Math.min(cursor, (name.length()-next)*2+i);
        }
        answer += cursor;
        return answer;
    }
}