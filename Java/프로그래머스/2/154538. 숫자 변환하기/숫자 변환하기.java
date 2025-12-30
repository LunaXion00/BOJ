import java.util.*;
class Solution {
    class Info{
        int number;
        int level;
        public Info(int number, int level){
            this.number = number;
            this.level = level;
        }
    }
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Info> q= new LinkedList<>();
        q.offer(new Info(y, 0));
        while(!q.isEmpty()){
            Info now = q.poll();
            if(now.number == x){
                answer = now.level;
                break;
            }
            if(now.number%3 == 0 && now.number/3 >= x) q.offer(new Info(now.number/3, now.level+1));
            if(now.number%2 == 0 && now.number/2 >= x) q.offer(new Info(now.number/2, now.level+1));
            if(now.number-n >= x) q.offer(new Info(now.number-n, now.level+1));
        }
        return answer;
    }
}