class Solution {
    public String solution(String s) {
        String a = "";
        if(s.length() % 2 == 1) a+=s.charAt(s.length()/2);
        else a+=s.charAt(s.length()/2-1)+""+s.charAt(s.length()/2);
        return a;
    }
}