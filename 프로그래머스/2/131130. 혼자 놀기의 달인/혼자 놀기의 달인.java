import java.util.*;
class Solution {
    boolean[] visited;
    public int solution(int[] cards) {
        visited = new boolean[cards.length];
        List<Integer> box = new ArrayList<>();
        for(int i = 0; i<cards.length; i++){
            if(!visited[i]){
                int size = findCycle(cards, i);
                box.add(size);
            }
        }
        if(box.size() == 1) return 0;
        Collections.sort(box, Collections.reverseOrder());
        return box.get(0)*box.get(1);
    }
    private int findCycle(int[] cards, int index){
        int size = 0;
        int current = index;
        while(!visited[current]){
            visited[current] = true;
            current = cards[current]-1;
            size++;
        }
        return size;
    }
}