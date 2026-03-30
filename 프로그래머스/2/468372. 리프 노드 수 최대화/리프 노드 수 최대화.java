import java.util.*;
class Solution {
    static int dist_limit, split_limit;
    static int answer;
    public int solution(int dist_limit, int split_limit) {
        answer = 0;
        this.dist_limit = dist_limit;
        this.split_limit = split_limit;
        // 전체 노드의 수. 리프 노드는 total - 분배 노드 수 - 1(루트) 로 계산.
        int total = 2;
        // Level 1의 노드 하나를 두고 시작. 분배도는 1, 분배 노드는 아직 없음. 
        int split = 1;
        int dist = 0;
        int node_in_level = 1;
        
        dfs(total, split, dist, node_in_level);
        
        return answer;
    }
    private void dfs(long total, long split, long dist, long node_in_level){
        answer = (int)Math.max(total-dist-1, answer);
        long dist_available = dist_limit - dist;
        if(dist_available <= 0) return;
        // 자식 노드를 2개로 설정. 만약 split_limit보다 커진다면 진행 x(이 경우, 당연히 자식 노드 3개도 안됨).
        if(split*2>split_limit) return;
        long next = (int)Math.min(dist_available, node_in_level);
        dfs(total+next*2, split*2, dist+next, next*2);
        // 자식 노드를 3개로 설정. 만약 split_limit보다 커진다면 진행 x.
        if(split*3 > split_limit) return;
        dfs(total+next*3, split*3, dist+next, next*3);

    }
}