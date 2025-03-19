import java.util.*;
class Solution {
    static int bus_hour = 9;
    static int bus_minute= 0;
    public String solution(int n, int t, int m, String[] timetable) {
        int bus_time = 9*60;
        int latest = 0;
        PriorityQueue<Integer> waiting = new PriorityQueue<>();
        for(String time:timetable){
            String[] a = time.split("\\:");
            waiting.add(Integer.parseInt(a[0])*60+Integer.parseInt(a[1]));
        }
        int riding = 0;
        for(int i = 0; i<n; i++){
            riding = 0;
            while(!waiting.isEmpty()){
                int crew = waiting.peek();
                if(crew<=bus_time && riding < m){
                    waiting.poll();
                    riding++;
                } else break;
                latest = crew - 1;
            }
            bus_time += t;
        }
        if(riding<m) latest = bus_time - t;
        return timeToString(latest/60, latest%60);
    }
    private static String timeToString(int hour, int minute){
        StringBuilder sb = new StringBuilder();
        if(hour < 10) sb.append("0");
        sb.append(hour+":");
        if(minute<10) sb.append("0");
        sb.append(minute+"");
        return sb.toString();
    }
}