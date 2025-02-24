import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(!Arrays.asList(words).contains(target)) return 0;
        Queue<String> q = new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(words));
        
        q.offer(begin);
        list.remove(begin);
        while(!q.isEmpty()){
            for(int i = 0; i<q.size(); i++){
                String current = q.poll();
                
                if(current.equals(target)) return answer;
                
                Iterator<String> it = list.iterator();
                while(it.hasNext()){
                    String word = it.next();
                    if(convertable(word, current)){
                        q.offer(word);
                        it.remove();
                    }
                }
            }
            answer++;
        }
        return answer;
    }
    private boolean convertable(String word, String current){
        int cnt = 0;
        for(int i = 0; i<current.length(); i++){
            if(word.charAt(i) != current.charAt(i)) cnt++;
        }
        return cnt==1;
    }
}