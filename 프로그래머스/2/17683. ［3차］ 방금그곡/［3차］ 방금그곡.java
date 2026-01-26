class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int longest = -1;
        m = convert(m);
        for(String s : musicinfos){
            String[] info = s.split(",");
            int start = convertTime(info[0]);
            int end = convertTime(info[1]);
            int playTime = end-start;
            String melody = convert(info[3]);
            int repeat = playTime/melody.length();
            int remain = playTime%melody.length();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<repeat; i++) sb.append(melody);
            sb.append(melody, 0, remain);
            String total = sb.toString();
            if(total.contains(m)) {
                if(longest < playTime){
                    answer = info[2];
                    longest = playTime;
                }
            }
        }
        return answer;
    }
    private static String convert(String s){
        String con = "";
        for(int i = 0; i<s.length(); i++){
            if(i < s.length()-1 && s.charAt(i+1) == '#') con += Character.toLowerCase(s.charAt(i++));
            else con += s.charAt(i);
        }
        return con;
    }
    private static int convertTime(String s){
        String[] time = s.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}