import java.util.*;
class Solution {
    static int[] rates;
    static int[][] u;
    static int[] emoji;
    static int emoji_cnt;
    static int user;
    static int subscriber = -1;
    static int selling = -1;
    public int[] solution(int[][] users, int[] emoticons) {
        user = users.length;
        u = users;
        emoji = emoticons;
        emoji_cnt = emoticons.length;
        rates = new int[emoji_cnt];
        brute(0);
        return new int[]{subscriber, selling};
    }
    public static void brute(int index){
        if(index == emoji_cnt){
            calculate();
            return;
        }
        for(int i = 10; i<=40; i+=10){
            rates[index] = i;
            brute(index+1);
        }
    }
    public static void calculate(){
        int sub = 0;
        int sell = 0;
        for(int i = 0; i< user; i++){
            int temp = 0;
            for(int j = 0; j<emoji_cnt; j++){
                if(rates[j] >= u[i][0]) temp += emoji[j]*(100-rates[j])/100;
            }
            if(temp >= u[i][1]) sub+=1;
            else sell += temp;
        }
        if(sub > subscriber){
            subscriber = sub;
            selling = sell;
        }
        else if(sub == subscriber) selling = Math.max(sell, selling);
    }
}