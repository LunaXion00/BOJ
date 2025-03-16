class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i= 0; i<schedules.length; i++){
            int schedule_hour = schedules[i]/100;
            int schedule_min = schedules[i]%100;
            if(schedule_min >= 50){
                schedule_hour += 1;
                schedule_min = (schedule_min + 10)%60;
            }
            else{
                schedule_min += 10;
            }
            int limit = schedule_hour*100+schedule_min;
            for(int j = 0; j<7; j++){
                int today = (startday+j)%7;
                if(today >=1 && today <=5) {
                    if(limit < timelogs[i][j]) break;
                }
                if(j==6) answer++;
            }
        }
        return answer;
    }
}