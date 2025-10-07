import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int[] time_count = new int[360000];
        long total_time = 0;
        int answer_time = 0;
        int playtime = convertTimeToInt(play_time);
        int advtime = convertTimeToInt(adv_time);
        for(int i = 0; i<logs.length; i++){
            String[] times = logs[i].split("-");
            int start = convertTimeToInt(times[0]);
            int end = convertTimeToInt(times[1]);
            for(int j = start; j<end; j++) time_count[j]++;
        }
        for(int i = 0; i<advtime; i++) total_time += time_count[i];
        long total_max = total_time;
        for(int i = advtime; i<playtime; i++){
            total_time = total_time + time_count[i] - time_count[i-advtime];
            if(total_max < total_time){
                total_max = total_time;
                answer_time = i-advtime+1;
            }
        }
        return convertIntToTime(answer_time);
    }
    public int convertTimeToInt(String time){
        String[] split_time = time.split(":");
        return Integer.parseInt(split_time[0])*3600+Integer.parseInt(split_time[1])*60+Integer.parseInt(split_time[2]);
    }
    public String convertIntToTime(int time){
        int hour = time/3600;
        int min = (time - 3600 * hour) / 60;
        int sec = time%60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}