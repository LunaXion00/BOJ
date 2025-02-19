import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();
        StringTokenizer st;
        for(int i = 0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (command.equals("I")){
                maxQ.add(num);
                minQ.add(num);
            }
            else{
                if(num == 1 && !maxQ.isEmpty())
                    minQ.remove(maxQ.poll());
                else if(num == -1 && !minQ.isEmpty())
                    maxQ.remove(minQ.poll());
            }
        }
        int max = maxQ.isEmpty()?0:maxQ.poll();
        int min = minQ.isEmpty()?0:minQ.poll();
        return new int[]{max, min};
    }
}