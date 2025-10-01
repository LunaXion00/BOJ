import java.util.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> answer = new ArrayList<>();
        for(int[] ball: balls){
            int endX = ball[0];
            int endY = ball[1];
            int dist = Integer.MAX_VALUE;
            // 오른쪽 벽. 가는 경로에 공이 있으면 안됨. 
            if(!(startX <= endX && startY == endY)) dist = Math.min(dist, calc_dist(startX, startY, 2*m-endX, endY));
            // 왼쪽 벽
            if(!(startX >= endX && startY == endY)) dist = Math.min(dist, calc_dist(startX, startY, -endX, endY));
            // 윗벽
            if(!(startX == endX && startY >= endY)) dist = Math.min(dist, calc_dist(startX, startY, endX, -endY));
            // 아랫벽
            if(!(startX == endX && startY <= endY)) dist = Math.min(dist, calc_dist(startX, startY, endX, 2*n-endY));
            answer.add(dist);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
    public int calc_dist(int startX, int startY, int endX, int endY) {
        return (int) (Math.pow(startX - endX, 2) + Math.pow(startY - endY, 2));
    }
}