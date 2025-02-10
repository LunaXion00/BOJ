import java.util.*;
class Solution {
    ArrayList<String> answer = new ArrayList<>();
    static int[] parents = new int[2501];
    static String[] table = new String[2501];
    static final String EMPTY = "EMPTY";
    public String[] solution(String[] commands) {
        int command_cnt = commands.length;
        
        for(int i = 0; i<parents.length; i++) parents[i] = i;
        
        for(int i = 0; i<command_cnt; i++){
            StringTokenizer st = new StringTokenizer(commands[i]);
            switch(st.nextToken()){
                case "UPDATE":
                    doUpdate(st);
                    break;
                case "MERGE":
                    doMerge(st);
                    break;
                case "UNMERGE":
                    doUnmerge(st);
                    break;
                case "PRINT":
                    doPrint(st);
                    break;
            }
        }
        return answer.toArray(new String[0]);
    }
    
    private int getIndex(int r, int c){
        return 50*(r-1)+c;
    }
    
    private int find(int x){
        if(parents[x] != x) parents[x] = find(parents[x]);
        return parents[x];
    }
    
    private void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            table[a] = getValue(a, b);
            table[b] = null;
            parents[b] = a;
        }
    }
    
    private String getValue(int a, int b){
        String v1 = table[a];
        String v2 = table[b];
        if(v1 != null) return v1;
        return v2;
    }
    
    private void doPrint(StringTokenizer st){
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int parent = find(getIndex(r, c));
        String value = table[parent];
        if(value == null) answer.add(EMPTY);
        else answer.add(value);
    }
    
    private void doUpdate(StringTokenizer st){
        int index = st.countTokens();
        if(index == 3) updateValueByPos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
        else updateValueByValue(st.nextToken(), st.nextToken());
    }
    
    private void updateValueByPos(int r, int c, String value){
        int parent = find(getIndex(r, c));
        table[parent] = value;
    }
    
    private void updateValueByValue(String value1, String value2){
        for(int i = 1; i<parents.length; i++){
            if(value1.equals(table[i])){
                table[i] = value2;
            }
        }
    }
    
    private void doMerge(StringTokenizer st){
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        
        union(getIndex(r1, c1), getIndex(r2, c2));
    }
    
    private void doUnmerge(StringTokenizer st){
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        for(int i = 1; i<parents.length; i++) find(i);
        
        int parent = parents[getIndex(r, c)];
        String value = table[parent];
        for(int i = 1; i<parents.length; i++){
            if(parents[i] == parent){
                parents[i] = i;
                table[i] = null;
            }
        }
        table[getIndex(r,c)] = value;
    }
}