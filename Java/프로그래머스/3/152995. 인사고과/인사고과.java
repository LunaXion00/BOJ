import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        int wan_total = wanho[0]+wanho[1];
        int highscore = 0;
        Arrays.sort(scores, (a,b)-> a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        for(int[] score:scores){
            if(highscore <= score[1]){
                highscore = score[1];
                if(score[0]+score[1] > wan_total) answer++;
            }
            else{
                if(score.equals(wanho)) return -1;
            }
        }
        return answer;
    }
}