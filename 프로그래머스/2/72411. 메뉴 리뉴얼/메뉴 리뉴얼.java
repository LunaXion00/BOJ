import java.util.*;
class Solution {
    static HashMap<String, Integer> candidate = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(String order: orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            make_course(new String(chars), "", 0);
        }
        
        List<String> keySet = new ArrayList<>(candidate.keySet());
        keySet.sort((o1, o2)-> candidate.get(o2)- candidate.get(o1));
        // for(String i : keySet) System.out.println(i+" "+candidate.get(i));
        for(int i: course){
            int max = 0;
            for(String s : keySet){
                int count = candidate.get(s);
                if(count > 1 && s.length() == i){
                    if(count >= max){
                        answer.add(s);
                        max = count;
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    private static void make_course(String order, String course, int depth){
        if(depth == order.length()) {
            if(course.length() >= 2){
                candidate.put(course, candidate.getOrDefault(course, 0)+1);
            }            
            return;
        }
        make_course(order, course+order.charAt(depth), depth+1);
        make_course(order, course, depth+1);
    }
}