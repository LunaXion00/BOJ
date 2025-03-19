class Solution{
    String objective;
    public int solution(String s){
        objective = s;
        for(int i = s.length(); i>0; i--){
            for(int j= 0; j+i<=s.length(); j++){
                if(isPalindrome(j, j+i-1)) return i;
            }
        }
        return 0;
    }
    public boolean isPalindrome(int start, int end){
        while(start<=end){
            if(objective.charAt(start++) != objective.charAt(end--)) return false;
        }
        return true;
    }
}