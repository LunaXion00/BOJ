class Solution {
    public String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    public int[] month = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String solution(int a, int b) {
        String answer = "";
        int days = 0;
        for(int i = 0; i<a-1; i++){
            days += month[i];
        }
        days += b-1;
        return week[days%7];
    }
}