import java.util.*;
class Solution {
    public static class Room{
        int no;
        int end_time;
        public Room(int no, int end_time){
            this.no = no;
            this.end_time = end_time;
        }
    }
    public static class RoomComparator implements Comparator<Room>{
        @Override
        public int compare(Room r1, Room r2){
            return r1.end_time-r2.end_time; 
        }
    }
    public int solution(String[][] book_time) {
        int answer = 1;
        PriorityQueue<Room> pq = new PriorityQueue<>(1, new RoomComparator());
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        pq.offer(new Room(answer, convertTime(book_time[0][1])+10));
        for(int i = 1; i<book_time.length; i++){
            Room fastest = pq.peek();
            int this_start = convertTime(book_time[i][0]);
            int this_end = convertTime(book_time[i][1])+10;
            if(this_start >= fastest.end_time){
                pq.offer(new Room(pq.poll().no, this_end));
            }
            else{
                pq.offer(new Room(++answer, this_end));
            }
        }
        return answer;
    }
    public int convertTime(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        return hour*60+min;
    }
}