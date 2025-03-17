import java.util.*;
class Solution {
    List<Integer> choice = new ArrayList<>();
    List<Integer> choice_b = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    int[][] dices;
    List<Integer> sumA;
    List<Integer> sumB;
    int[][] diceA;
    int[][] diceB;
    HashMap<List<Integer>, Integer> visited = new HashMap<>();
    int N;
    int win_count = Integer.MIN_VALUE;
    public int[] solution(int[][] dice) {
        N = dice.length;
        dices = dice;
        choiceDice(0, 0);    
        return answer.stream().mapToInt(i->i+1).toArray();
    }
    
    public void choiceDice(int depth, int s){
        if(depth == N/2){
            if(visited.containsKey(choice)) return;
            int[] m = calculateWinCnt();
            if(m[0] > win_count){
                answer = new ArrayList<>(choice);
                win_count= m[0];
            }
            if(m[1]>win_count){
                answer = new ArrayList<>(choice_b);
                win_count=m[1];
            }
            return;
        }
        for(int i = s; i<N; i++){
            choice.add(i);
            choiceDice(depth+1, i+1);
            choice.remove(choice.size()-1);
        }
    }
    public int[] calculateWinCnt(){
        simulate();
        int a_win = 0;
        int b_win = 0;
        Collections.sort(sumA);
        Collections.sort(sumB);
        for(int index: sumA){
            int left = 0, right = sumB.size()-1;
            int value = Integer.MIN_VALUE;
            while(left <= right){
                int mid = (left+right)/2;
                if(sumB.get(mid) < index){
                    left = mid+1;
                    value = Math.max(value, mid);
                }else{
                    right = mid-1;
                }
            }
            if(value != Integer.MIN_VALUE) a_win += value+1;
        }
        for(int index: sumB){
            int left = 0, right = sumA.size()-1;
            int value = Integer.MIN_VALUE;
            while(left <= right){
                int mid = (left+right)/2;
                if(sumA.get(mid) < index){
                    left = mid+1;
                    value = Math.max(value, mid);
                }else{
                    right = mid-1;
                }
            }
            if(value != Integer.MIN_VALUE) b_win += value+1;
        }
        return new int[]{a_win, b_win};
    }
    public void simulate(){
        choice_b = new ArrayList<>();
        diceA = new int[N/2][6];
        diceB = new int[N/2][6];
        sumA = new ArrayList<>();
        sumB = new ArrayList<>();
        int a = 0, b = 0;
        for(int i = 0; i<N; i++) {
            if(!choice.contains(i)) {
                choice_b.add(i);
                diceB[b++] = dices[i];
            }else{
                diceA[a++] = dices[i];
            }
               
        }
        visited.put(choice, 0);        
        visited.put(choice_b, 0);
        makeSumA(0, 0);
        makeSumB(0, 0);
    }
    public void makeSumA(int depth, int sum){
        if(depth == N/2){
            sumA.add(sum);
            return;
        }
        for(int i = 0; i<6; i++){
            int newSum = sum + diceA[depth][i];
            makeSumA(depth+1, newSum);
        }
    }
    public void makeSumB(int depth, int sum){
        if(depth == N/2){
            sumB.add(sum);
            return;
        }
        for(int i = 0; i<6; i++){
            int newSum = sum + diceB[depth][i];
            makeSumB(depth+1, newSum);
        }
    }
}