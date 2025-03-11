import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        long[] banToNum = Arrays.stream(bans)
            .mapToLong(this::ConvertToNum)
            .sorted()
            .toArray();
        for(int i = 0; i<banToNum.length; i++){
            if(banToNum[i]<=n) n++;
            else break;
        }
        return ConvertToString(n);
    }
    public long ConvertToNum(String st){
        long num = 0;
        int len = st.length();
        long a = 1;
        for(int i = len-1; i>=0; i--){
            num += (st.charAt(i) - 'a'+1) * a;
            a *= 26;
        }
        return num;
    }
    public String ConvertToString(long num){
        StringBuilder st = new StringBuilder();
        while(num-- > 0){
            char c = (char)('a' + (int)(num % 26));
            st.append(c);
            num /= 26;
        }
        return st.reverse().toString();
    }
}