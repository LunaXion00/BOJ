import java.util.*;
class Solution {
    static HashMap<Long, Long> map;
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        map = new HashMap<>();
        for(int i = 0; i<room_number.length; i++){
            answer[i] = find_room(room_number[i]);
        }
        return answer;
    }
    private static long find_room(long room){
        // 빈 방이라면 map에 그 방의 다음 번호를 기록 후 방 번호 리턴.
        if(!map.containsKey(room)){
            map.put(room, room+1);
            return room;
        }
        // 해당 방이 차있으면 그 다음으로 가능한 방의 번호를 재귀적으로 확인. 그 과정에서 확인한 방들의 다음 방을 변경.
        long next = find_room(map.get(room));
        map.put(room, next);
        return next;
    }
}