class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        while(n>0){
            int r = n%3;
            if(r == 0) n--;
            answer = numbers[r]+answer;
            n /= 3;
        }
        return answer;
    }
}