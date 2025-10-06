import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] path : paths){
            edges.putIfAbsent(path[0], new ArrayList<>());
            edges.get(path[0]).add(new int[]{path[1],path[2]});
            edges.putIfAbsent(path[1], new ArrayList<>());
            edges.get(path[1]).add(new int[]{path[0],path[2]});
        }
        Arrays.sort(summits);
        
        Set<Integer> summitSet = new HashSet<>();
        for(int i : summits){
            summitSet.add(i);
        }
        Queue<int[]> pq = new PriorityQueue<>((o1, o2)-> o1[1]-o2[1]);
        int[] min_path = new int[n+1];
        Arrays.fill(min_path, Integer.MAX_VALUE);
        
        for(int gate:gates){
            pq.add(new int[]{gate, 0});
            min_path[gate] = 0;
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cur_v = cur[0];
            int cur_i = cur[1];
            
            if(min_path[cur_v]<cur_i) continue;
            if(summitSet.contains(cur_v)) continue;
            for(int[] edge: edges.get(cur_v)){
                int next_v = edge[0];
                int next_i = edge[1];
                
                int nextW = Math.max(next_i, min_path[cur_v]);
                if(nextW < min_path[next_v]){
                    min_path[next_v] = nextW;
                    pq.add(new int[]{next_v, min_path[next_v]});
                }
            }
        }
        int minSummit=summits[0];
        int minSummitIntensity=Integer.MAX_VALUE;

        for(int summit: summits){
            if(min_path[summit]<minSummitIntensity){
                minSummit=summit;
                minSummitIntensity = min_path[summit];
            }
        }
        return new int[]{minSummit, minSummitIntensity};
    }
}