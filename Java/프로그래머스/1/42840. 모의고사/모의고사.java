import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] score = new int[]{0,0,0};
        int[] case_1 = new int[]{1,2,3,4,5};
        int[] case_2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] case_3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i<answers.length; i++){
            if(case_1[i%5] == answers[i]) score[0]++;
            if(case_2[i%8] == answers[i]) score[1]++;
            if(case_3[i%10]== answers[i]) score[2]++;
        }
        int max = Arrays.stream(score).max().getAsInt();
        for(int i = 0; i<3; i++){
            if(score[i] == max) answer.add(i+1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}