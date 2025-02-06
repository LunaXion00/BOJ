import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int soldier = n;
        int skill = k;
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<enemy.length; i++){
            pq.add(enemy[i]);
            soldier -= enemy[i];
            if(soldier<0){
                if(skill > 0 && !pq.isEmpty()){
                    soldier += pq.poll();
                    skill--;
                }
                else{
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}