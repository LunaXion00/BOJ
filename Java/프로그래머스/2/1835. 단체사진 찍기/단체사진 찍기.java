class Solution {
    static boolean[] visited;
    static char[] friends;
    static String[] condition;
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        condition = data;
        dfs(0, "");
        return answer;
    }
    static public void dfs(int depth, String line){
        if(depth == 8){
            if(check(line)) answer++;
            return;
        }
        for(int i = 0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, line+friends[i]);
                visited[i] = false;
            }
        }
    }
    static public boolean check(String line){
        for(String s:condition){
            char sign = s.charAt(3);
            int num = s.charAt(4)-'0';
            int diff = Math.abs(line.indexOf(s.charAt(0)) - line.indexOf(s.charAt(2))) - 1;
            if(sign == '=') {
                if(diff != num) return false;
            }
            else if(sign == '>') {
                if(diff <= num) return false;
            }
            else if(sign == '<') {
                if(diff >= num) return false;
            }
        }
        return true;
    }
}