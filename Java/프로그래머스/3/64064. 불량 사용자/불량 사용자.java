import java.util.*;
class Solution {
    static String[] userID;
    static String[] bannedID;
    static HashSet<HashSet<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        userID = user_id;
        bannedID = banned_id;
        result = new HashSet<>();
        dfs(new HashSet<>(), 0);
        return result.size();
    }
    public void dfs(HashSet<String> set, int depth){
        if(depth == bannedID.length){
            result.add(set);
            return;
        }
        for(int i = 0; i<userID.length; i++){
            if(set.contains(userID[i])) continue;
            if(filter(userID[i], bannedID[depth])) {
                set.add(userID[i]);
                dfs(new HashSet<>(set), depth+1);
                set.remove(userID[i]);
            }
        }
    }
    public boolean filter(String id, String ban_id){
        if(id.length() != ban_id.length()) return false;
        for(int i = 0; i<id.length(); i++){
            if(ban_id.charAt(i)=='*') continue;
            else if(id.charAt(i) != ban_id.charAt(i)) return false;
        }
        return true;
    }
}