import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> a = splitString(str1);
        List<String> b = splitString(str2);
        if(a.isEmpty() && b.isEmpty()) return 65536;
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        
        for(String s : a){
            if(b.remove(s)) inter.add(s);
            union.add(s);
        }
        union.addAll(b);
        double j = (double) inter.size() / (double) union.size();
        return (int) (j * 65536);
    }
    private List<String> splitString(String str){
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2).replaceAll("[^a-z]", "");
            if (s.length() < 2) {
                continue;
            }
            list.add(s);
        }
        return list;
    }
}