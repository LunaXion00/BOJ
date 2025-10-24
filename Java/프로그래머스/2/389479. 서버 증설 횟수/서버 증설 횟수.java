class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[players.length];
        for(int i = 0; i<players.length; i++){
            server[i] = players[i]/m;
        }
        for(int i = 0; i<server.length; i++){
            if(server[i] > 0){
                int plus = server[i];
                answer += plus;
                for(int j = i; j<Math.min(server.length, i+k); j++){
                    server[j] -= plus;
                }
            }
        }
        return answer;
    }
}