import java.util.*;
class Solution {
    static class Node{
        int selling = 0;
        Node parent = null;
        ArrayList<Node> child = new ArrayList<>();
    }
    static HashMap<String, Node> graph;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        graph = new HashMap<String, Node>();
        graph.put("-", new Node());
        for(int i = 0; i<enroll.length; i++){
            graph.put(enroll[i], new Node());
        }
        for(int i = 0; i<referral.length; i++){
            Node parent_node = graph.get(referral[i]);
            Node child_node = graph.get(enroll[i]);
            child_node.parent = parent_node;
            parent_node.child.add(child_node);
        }
        
        for(int i = 0; i<seller.length; i++){
            Node leaf = graph.get(seller[i]);
            int sell = amount[i]*100;
            multilevel(leaf, sell);
        }
        for(int i = 0; i<answer.length; i++){
            answer[i] = graph.get(enroll[i]).selling;
        }
        return answer;
    }
    public void multilevel(Node leaf, int sell){
        // 본인이 루트(민호)거나 절사할 금액이 안된다면 모두 가짐.
        if(sell < 10 || leaf.parent == null){
            leaf.selling += sell;
            return;
        }
        int taken = sell / 10;
        leaf.selling += sell-taken;
        multilevel(leaf.parent, taken);
    }
}