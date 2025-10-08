import java.util.*;
class Solution {
    static int answer;
    static int[] extended;
    static int remainWeak;
    static boolean[] visited;
    public int solution(int n, int[] weak, int[] dist) {
        answer = -1;
        visited = new boolean[dist.length];
        remainWeak = weak.length;
        extended = new int[remainWeak *2 - 1];
        for (int i = 0; i < weak.length; i++) {
			extended[i] = weak[i];
		}
		for (int i = 0; i < weak.length - 1; i++) {
			extended[i + weak.length] = weak[i] + n;
		}
        
        for(int i = 1; i<=dist.length; i++){
            perm(0, i, dist, new int[i]);
        }
        return answer;
    }
    public void perm(int depth, int cnt, int[] dist, int[] select){
        if(answer != -1) return;
        if(depth == cnt){
            check(select);
            return;
        }
        for(int i = 0; i<dist.length; i++){
            if(visited[i]) continue;
            select[depth] = dist[i];
            visited[i] = true;
            perm(depth+1, cnt, dist, select);
            visited[i] = false;
        }
    }
    public void check(int[] select){
        outer:for(int i = 0; i<remainWeak; i++){
            int start= i;
            int f = 0;
            for (int j = i; j < i + remainWeak; j++) {
				if (extended[j] - extended[start] > select[f]) {
					start = j;
					f++;
				}
				if (f == select.length) {
					continue outer;
				}
			}
			answer = select.length;
			return;
        }
    }
}