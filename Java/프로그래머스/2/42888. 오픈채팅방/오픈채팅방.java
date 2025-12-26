import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> member = new HashMap<>();
        for(String log:record){
            String[] words = log.split(" ");
            if(words[0].equals("Enter")) {
                if(member.containsKey(words[1])) member.replace(words[1], words[2]);
                else member.put(words[1], words[2]);
            }
            else if(words[0].equals("Change")) member.replace(words[1], words[2]);
        }
        for(String log:record){
            String[] words = log.split(" ");
            if(words[0].equals("Enter"))
                answer.add(member.get(words[1])+"님이 들어왔습니다.");
            else if(words[0].equals("Leave")) 
                answer.add(member.get(words[1])+"님이 나갔습니다.");
            else 
                continue;
        }
        return answer.stream().toArray(String[]::new);
    }
}