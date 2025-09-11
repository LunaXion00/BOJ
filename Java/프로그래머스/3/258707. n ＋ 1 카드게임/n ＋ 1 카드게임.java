import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int round = 0, coins = coin, n = cards.length;
        Set<Integer> hand = new HashSet<>();
        Set<Integer> recycle = new HashSet<>();
        int index = n/3;
        for(int i = 0; i< index; i++) hand.add(cards[i]);
        while(true){
            round++;
            if(index >= n) break;
            recycle.add(cards[index++]);
            recycle.add(cards[index++]);
            boolean flag = false;
            for(int num: hand){
                // 핸드만으로 해결
                if(hand.contains(n+1-num)){
                    hand.remove(num);
                    hand.remove(n+1-num);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                // 일단 코인 1개 내에서
                if(coins>0){
                    for(int num:hand){
                        if(recycle.contains(n+1-num)){
                            hand.remove(num);
                            recycle.remove(n+1-num);
                            flag = true;
                            coins -= 1;
                            break;
                        }
                    }
                }
            }
            if(!flag){
                if(coins>1){
                    for(int num:recycle){
                        if(recycle.contains(n+1-num)){
                            recycle.remove(num);
                            recycle.remove(n+1-num);
                            flag = true;
                            coins -= 2;
                            break;
                        }
                    }
                }
            }
            if(!flag) break;
        }
        return round;
    }
}