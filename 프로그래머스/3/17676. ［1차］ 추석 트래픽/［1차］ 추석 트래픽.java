import java.util.*;
class Solution {
    class Log implements Comparable<Log>{
        int start;
        int end;
        public Log(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Log o1){
            if(this.end == o1.end) return this.start-o1.start;
            else return this.end - o1.end;
        }
    }
    public int solution(String[] lines) {
        int answer = 0;
        List<Log> timeline = new ArrayList<>();
        for(String line : lines){
            int[] log = transfer(line);
            timeline.add(new Log(log[0], log[1]));
        }
        Collections.sort(timeline);
        for(Log log:timeline){
            int start = log.start;
            int end = log.end;
            int count_1 = 0;
            int count_2 = 0;
            for(Log next:timeline){
                if(start > next.end || start+999 < next.start) continue;
                count_1++;
            }
            for(Log next:timeline){
                if(end > next.end || end+999 < next.start) continue;
                count_2++;
            }
            answer = Math.max(Math.max(count_1, count_2), answer);
        }
        return answer;
    }
    private static int[] transfer(String line){
        String[] a = line.split(" ");
        String[] times = a[1].split("[:.]");
        double t = Double.parseDouble(a[2].replace("s", ""))*1000;
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(times[2]);
        int milisec = Integer.parseInt(times[3]);
        int finish = (hour * 3600 + min * 60 + sec)*1000 + milisec;
        return new int[]{finish-(int)t+1, finish};
    }
}