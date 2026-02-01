import java.util.*;
class Solution {
    class Point{
        long x;
        long y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    public String[] solution(int[][] line) {
        List<Point> list = new ArrayList<>();
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        for(int i = 0; i<line.length; i++){
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j = i; j<line.length; j++){
                if(j == i) continue;
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                if(a*d-b*c == 0) continue;
                else {
                    double x = (double) (b * f - e * d) / (a * d - b * c);
                    double y = (double) (e * c - a * f) / (a * d - b * c);
                    if(x % 1 == 0 && y % 1 == 0){                    
                        list.add(new Point((long)x, (long)y));   
                    }
                }
            }
        }
        for(Point p : list){
            if(p.x > maxX) maxX = p.x;
            if(p.y > maxY) maxY = p.y;
            if(p.x < minX) minX = p.x;
            if(p.y < minY) minY = p.y;
        }
        int r = (int)(maxY-minY+1);
        int c = (int)(maxX-minX+1);
        char[][] single = new char[r][c];
        for(int i = 0; i<single.length; i++) for(int j = 0; j<single[i].length; j++) single[i][j] = '.';
        for(Point p : list){
            single[(int)(p.y-minY)][(int)(p.x-minX)] = '*';
        }
        String[] answer = new String[r];
        for(int i = 0; i<answer.length; i++) answer[i] = new String(single[answer.length-1-i]);
        
        return answer;
    }
}