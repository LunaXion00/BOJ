import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int ans = 0;
        int friendlen = friends.length;
        
        HashMap<String, Integer> hash = new HashMap<>();
        
        int[] giftdegree = new int[friendlen];
        int[][] giftgraph = new int[friendlen][friendlen];
        
        for(int i =0; i<friendlen; i++) hash.put(friends[i], i);
        
        for(String gift : gifts){
            String[] relation = gift.split(" ");
            giftdegree[hash.get(relation[0])]++;
            giftdegree[hash.get(relation[1])]--;
            giftgraph[hash.get(relation[0])][hash.get(relation[1])]++;
        }
        for(int i = 0; i<friendlen; i++){
            int cnt = 0;
            for(int j = 0; j<friendlen; j++){
                if(i==j) continue;
                if(giftgraph[i][j] > giftgraph[j][i]) cnt++;
                else if(giftgraph[i][j] == giftgraph[j][i] && giftdegree[i] > giftdegree[j]){
                    cnt++;
                }
            }
            ans = Math.max(cnt, ans);
        }
        return ans;  
    }
}