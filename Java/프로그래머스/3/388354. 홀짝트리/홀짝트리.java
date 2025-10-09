import java.util.*;
class Solution {
    static int[] parent;
    public class Tree{
        int evenNode = 0;
        int oddNode = 0;
        int reverseEvenNode = 0;
        int reverseOddNode = 0;
        public boolean isOEtree(){
            if(evenNode+oddNode == 1) return true;
            return false;
        }
        public boolean isROEtree(){
            if(reverseEvenNode+reverseOddNode == 1)return true;
            return false;
        }
    }
    public int[] solution(int[] nodes, int[][] edges) {
        int lastnode = 0;        
        for(int i:nodes) lastnode = Math.max(i, lastnode);
        parent = new int[lastnode + 1];
        int[] degree = new int[lastnode+1];
        for(int i = 1; i<=lastnode; i++) parent[i] = i;
        for(int[] edge : edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            merge(edge[0], edge[1]);
        }
        Map<Integer, Tree> forest = new HashMap<>();
        for(int node: nodes){
            int p = find(node);
            Tree t = forest.getOrDefault(p, new Tree());
            if(degree[node] % 2 == 0 && node % 2 == 0) t.evenNode++;
            else if(degree[node] % 2 == 1 && node % 2 == 1) t.oddNode++;
            else if(degree[node] % 2 == 1 && node % 2 == 0) t.reverseEvenNode++;
            else if(degree[node] % 2 == 0 && node % 2 == 1) t.reverseOddNode++;
            forest.put(p, t);
        }
        int OEtree = 0;
        int ROEtree = 0;
        for(Tree t : forest.values()){
            if(t.isOEtree()) OEtree++;
            if(t.isROEtree()) ROEtree++;
        }
        return new int[]{OEtree, ROEtree};
    }
    public int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    public void merge(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
}