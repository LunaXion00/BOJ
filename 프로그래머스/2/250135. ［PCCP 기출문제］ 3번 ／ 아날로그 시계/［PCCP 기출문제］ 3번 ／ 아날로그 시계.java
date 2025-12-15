class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int start = h1*3600+m1*60+s1;
        int end = h2*3600+m2*60+s2;
        int answer = calc(end)-calc(start);
        answer += alarmNow(start)?1:0;
        return answer;
    }
    public int calc(int sec){
        int min = sec*59/3600;
        int hour = sec * 719/43200;
        int overlap = 43200 <= sec ? 2 : 1;
        return min + hour - overlap;
    }
    public boolean alarmNow(int sec) {
        return sec*59/3600 == 0 || sec*719%43200 == 0;
    }
}