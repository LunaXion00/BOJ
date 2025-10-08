import java.util.*;
class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
        int[] basic_score = new int[pages.length];
        String[] url = new String[pages.length];
        
        List<List<String>> external = new ArrayList<>();
        for(int i = 0; i<pages.length; i++) external.add(new ArrayList<>());
        
        word = word.toLowerCase();
        
        for(int i = 0; i<pages.length; i++){
            StringTokenizer st = new StringTokenizer(pages[i], "\n");
            while(st.hasMoreTokens()){
                String line = st.nextToken();
                if(line.contains("meta") && line.contains("content") && url[i] == null){
                    StringTokenizer inline = new StringTokenizer(line, "\"");
                    while(inline.hasMoreTokens()){
                        String text = inline.nextToken();
                        if(text.startsWith("https")) {
                            url[i] = text;
                            break;
                        }
                    }
                }
                if(line.contains("<a href=")){
                    StringTokenizer inline = new StringTokenizer(line, "\"");
                    while(inline.hasMoreTokens()) {
                        String text = inline.nextToken();
                        if (text.startsWith("https")) {
                            external.get(i).add(text);
                        }
                    }
                }
                line = line.toLowerCase();
                line = line.replaceAll("[^a-z]", " ");
                StringTokenizer inline = new StringTokenizer(line, " ");
                while(inline.hasMoreTokens()){
                    if(word.equals(inline.nextToken())) basic_score[i]++;
                }
            }
        }
        double[] link_score = new double[pages.length];
        for(int i = 0; i<pages.length; i++){
            double score = basic_score[i] / (double) external.get(i).size();
            for(String hyperlink : external.get(i)){
                for(int j = 0; j<pages.length; j++){
                    if(url[j].equals(hyperlink)) link_score[j] += score;
                }
                
            }
        }
        double max_score = 0;
        for(int i = 0; i<pages.length; i++){
            double total_score = link_score[i] + basic_score[i];
            if(max_score < total_score) {
                answer = i;
                max_score = total_score;
            }
        }
        return answer;
    }
}