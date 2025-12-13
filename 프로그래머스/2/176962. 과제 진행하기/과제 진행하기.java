import java.util.*;

class Solution {
    public class Assign{
        String name;
        int startTime;
        int remainTime;
        public Assign(String name, int startTime, int remainTime){
            this.name = name;
            this.startTime = startTime;
            this.remainTime = remainTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Assign> pq = new PriorityQueue<>((o1, o2)-> (o1.startTime-o2.startTime));
        Stack<Assign> stack = new Stack<>();
        
        for(String[] plan: plans){
            pq.add(new Assign(plan[0], convertToTime(plan[1]), Integer.parseInt(plan[2])));
        }
        
        while(!pq.isEmpty()){
            Assign current = pq.poll();
            int time = current.startTime;
            
            if(!pq.isEmpty()){
                Assign next = pq.peek();
                int endTime = time + current.remainTime;
                
                // 다음 과제 시작 전에 현재 과제를 완료할 수 있는 경우
                if(endTime <= next.startTime){
                    answer.add(current.name);
                    time = endTime;
                    
                    // 중단된 과제 처리
                    while(!stack.isEmpty() && time < next.startTime){
                        Assign remain = stack.pop();
                        if(time + remain.remainTime <= next.startTime){
                            answer.add(remain.name);
                            time += remain.remainTime;
                        } else {
                            remain.remainTime -= (next.startTime - time);
                            stack.push(remain);
                            break;
                        }
                    }
                } else {
                    // 현재 과제를 끝내지 못하고 중단해야 하는 경우
                    current.remainTime -= (next.startTime - time);
                    stack.push(current);
                }
            } else {
                // 마지막 과제
                answer.add(current.name);
                while(!stack.isEmpty()){
                    answer.add(stack.pop().name);
                }
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    public int convertToTime(String start){
        String[] times = start.split(":");
        return Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
    }
}