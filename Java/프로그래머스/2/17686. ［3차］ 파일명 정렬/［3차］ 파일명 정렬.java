import java.util.*;
class Solution {
    class File implements Comparable<File>{
        String head;
        String number;
        int index;
        public File(String head, String number, int index){
            this.head = head;
            this.number =number;
            this.index = index;
        }
        @Override
        public int compareTo(File o1){
            if(this.head.compareToIgnoreCase(o1.head)!= 0) return this.head.compareToIgnoreCase(o1.head);
            else return Integer.parseInt(this.number)-Integer.parseInt(o1.number);
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();
        for(int i = 0; i<files.length; i++){
            String[] parsed = parseFile(files[i]);
            list.add(new File(parsed[0], parsed[1], i));
        }
        Collections.sort(list);
        for(int i = 0; i<files.length; i++){
            File cur = list.get(i);
            answer[i] = files[cur.index];
        }
        return answer;
    }
    public String[] parseFile(String file) {
    String head = "";
    String number = "";
    int index = 0;
    
    // HEAD 추출 - 숫자가 나올 때까지
    while (index < file.length() && !Character.isDigit(file.charAt(index))) {
        head += file.charAt(index);
        index++;
    }
    
    // NUMBER 추출 - 최대 5자리, 숫자가 아닐 때까지
    while (index < file.length() && Character.isDigit(file.charAt(index)) && number.length() < 5) {
        number += file.charAt(index);
        index++;
    }
    
    return new String[] { head, number };
}
    
}