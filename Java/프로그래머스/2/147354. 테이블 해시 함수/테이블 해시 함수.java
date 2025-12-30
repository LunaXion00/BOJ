import java.util.*;
import java.util.stream.Collectors;
class Solution {
    class Tuple{
        List<Integer> list;
        public Tuple(List<Integer> list){
            this.list = list;
        }
    }
    class TupleComparator implements Comparator<Tuple>{
        private int col;
        public TupleComparator(int col){
            this.col = col;
        }
        @Override
        public int compare(Tuple o1, Tuple o2){
            return o1.list.get(col)-o2.list.get(col)!=0?o1.list.get(col)-o2.list.get(col) : o2.list.get(0)-o1.list.get(0);
        }
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<Tuple> tuples = new ArrayList<>();
        for(int i = 0; i<data.length; i++){
            List<Integer> list = Arrays.stream(data[i])
                               .boxed()
                               .collect(Collectors.toList());
            tuples.add(new Tuple(list));
        }
        tuples.sort(new TupleComparator(col-1));
        for(int i = row_begin-1; i<row_end; i++){
            int si = 0;
            for(int num : tuples.get(i).list){
                si += num%(i+1);
            }
            answer ^= si;
        }
        return answer;
    }
}