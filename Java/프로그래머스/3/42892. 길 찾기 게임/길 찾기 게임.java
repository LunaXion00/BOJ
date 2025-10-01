import java.util.*;
class Solution {
    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();
    public class Node{
        int index;
        int x;
        int y;
        Node left = null;
        Node right = null;
        public Node(int i, int x, int y){
            this.index = i;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i<nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n1.y == n2.y ? n1.x-n2.x : n2.y-n1.y;
            }
        });
        Node root = nodes[0];
        for(int i = 1; i<nodes.length; i++) insert(root, nodes[i]);
        preOrder(root);
        postOrder(root);
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(x->x).toArray();
        answer[1] = postOrderList.stream().mapToInt(x->x).toArray();
        return answer;
    }
    public void insert(Node parent, Node child){
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }
        else{
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            postOrderList.add(root.index);
        }
    }
    public void preOrder(Node root){
        if(root != null){
            preOrderList.add(root.index);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}