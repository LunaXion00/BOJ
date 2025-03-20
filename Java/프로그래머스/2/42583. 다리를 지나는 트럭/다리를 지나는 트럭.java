import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i<bridge_length; i++) bridge.add(0);
        
        if(bridge_length == 1) return truck_weights.length+1;
        if(truck_weights.length == 1) return bridge_length+1;
        
        int index = 0;
        int current_weight = 0;
        while(index<truck_weights.length){
            current_weight -= bridge.poll();
            answer++;
            if(current_weight + truck_weights[index] <= weight){
                bridge.add(truck_weights[index]);
                current_weight += truck_weights[index];
                index++;
            } else bridge.add(0);
        }
        return answer+bridge_length;
    }
}