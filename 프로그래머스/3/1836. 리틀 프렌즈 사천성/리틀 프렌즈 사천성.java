import java.util.*;
class Solution {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static HashMap<Character, List<Point>> map = new HashMap<>();
    static List<Character> remain = new ArrayList<>();
    static char[][] cboard;
    public String solution(int m, int n, String[] board) {
        String answer = "";
        map.clear();
        remain.clear();
        cboard = new char[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++) {
                cboard[i][j] = board[i].charAt(j);
                if(cboard[i][j] == '.' || cboard[i][j] == '*') continue;
                List<Point> temp = map.getOrDefault(cboard[i][j], new ArrayList<>());
                temp.add(new Point(i, j));
                map.put(cboard[i][j], temp);
                if(!remain.contains(cboard[i][j])) remain.add(cboard[i][j]);
            }
        }
        Collections.sort(remain);
        int index = 0;
        while(remain.size() != 0){
            if(removeable(remain.get(index))){
                char removed = remain.remove(index);
                removeChar(removed);
                answer += removed;
                index = 0;
            } else{
                index++;
                if(index == remain.size()){
                    answer = "IMPOSSIBLE";
                    break;
                }
            }
        }
        return answer;
    }
    static private void removeChar(char c){
        List<Point> location = map.get(c);
        for(Point p : location){
            cboard[p.x][p.y] = '.';
        }
        map.remove(c);
    }
    static private boolean removeable(char c){
        Point p1 = map.get(c).get(0);
        Point p2 = map.get(c).get(1);
        // p1.x <= p2.x 임이 보장 되어 있음.
        if(p1.y < p2.y){
            if(checkRow(p1.x, p1.y, p2.y, c) && checkCol(p1.x, p2.x, p2.y, c)) return true;
            if(checkCol(p1.x, p2.x, p1.y, c) && checkRow(p2.x, p1.y, p2.y, c)) return true;
        } else{
            if(checkRow(p1.x, p2.y, p1.y, c) && checkCol(p1.x, p2.x, p2.y, c)) return true;
            if(checkCol(p1.x, p2.x, p1.y, c) && checkRow(p2.x, p2.y, p1.y, c)) return true;
        }
        return false;
    }
    static private boolean checkRow(int x, int y1, int y2, char c){
        for(int i = y1; i<= y2; i++){
            if(cboard[x][i] != '.' && cboard[x][i] != c) return false;
        }
        return true;
    }
    static private boolean checkCol(int x1, int x2, int y, char c){
        for(int i = x1; i<= x2; i++){
            if(cboard[i][y] != '.' && cboard[i][y] != c) return false;
        }
        return true;
    }
}