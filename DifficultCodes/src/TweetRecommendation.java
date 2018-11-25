import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TweetRecommendation {

	static int[] getRecomm(int[][] f_edges, int[][] l_edges, int t, int min) {
		if(f_edges == null || l_edges == null) {
			return new int[0];
		}
		List<Integer> userFo = new ArrayList<>();
		for(int i=0; i<f_edges.length; i++) {
			if(f_edges[i][0] == t){
				userFo.add(f_edges[i][1]);
			}
		}
		
		Map<Integer, Integer> tw = new HashMap<>();
		
		for(int i=0; i<l_edges.length; i++) {
			if(userFo.contains(l_edges[i][0])) {
				if(!tw.containsKey(l_edges[i][1])) {
					tw.put(l_edges[i][1], 1);
				}else {
					tw.put(l_edges[i][1], tw.get(l_edges[i][1]) + 1);
				}
			}
		}
		
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(tw.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
		
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
        	sortedMap.put(entry.getKey(), entry.getValue());
        }
		
		List<Integer> res = new ArrayList<>();
		
		for(Integer id : sortedMap.keySet()) {
			if(sortedMap.get(id) >= min) {
				res.add(id);
			}
		}
		
		int[] result = new int[res.size()];
		int count = 0;
		for(Integer id : res) {
			result[count++] = id;
		}
		return result;
	}
	
	static class Comp implements Comparator<Integer> {

		Map<Integer, Integer> map;
		
		public Comp(Map<Integer, Integer> map) {
			this.map = map;
		}
		
		@Override
		public int compare(Integer o1, Integer o2) {
			Integer value1 = map.get(o1);
			Integer value2 = map.get(o2);
			return (value2.compareTo(value1) == 0) ? 1 : value2.compareTo(value1);
		}
		
	}
	
		public static void main(String[] args) {
		int[][] fE = {{4, 3}, {1, 2}, {1, 3}, {1, 4}, {5, 6}, {4, 2}, {4, 3}};
		int[][] l = {{2, 10}, {3, 10}, {4, 10}, {2, 11}, {3, 12}, {4, 11}, {3, 11}};
		int u = 1;
		int min = 2;
		
		
		int[] res = getRecomm(fE, l, u, min);
		for(int i : res) {
			System.out.println(i);
		}
		
	}
}
