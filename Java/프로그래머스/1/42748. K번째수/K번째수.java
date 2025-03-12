import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        int cmd = commands.length;
        
        for(int i = 0; i<cmd; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = commands[i][0]-1; j<commands[i][1]; j++) list.add(array[j]);
            Collections.sort(list);
            answer.add(list.get(commands[i][2]-1));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}