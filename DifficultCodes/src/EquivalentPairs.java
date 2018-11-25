import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EquivalentPairs {

	public List<List<Integer>> getEquivalents(int[] nums){
		Set<Integer> sumSet = new HashSet<>();
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				int key = nums[i] + nums[j];
				List<List<Integer>> mapResult = new ArrayList<>();
				List<Integer> arr = new ArrayList<>();
				arr.add(nums[i]);
				arr.add(nums[j]);
				if(map.containsKey(key)){
					mapResult = map.get(key);
					mapResult.add(arr);
					map.put(key, mapResult);
				}else {
					mapResult.add(arr);
					map.put(key, mapResult);
				}
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for(Entry<Integer, List<List<Integer>>> entry : map.entrySet()){
			if(entry.getValue().size() % 2 == 0){
				result.addAll(entry.getValue());
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		EquivalentPairs obj = new EquivalentPairs();
		int nums[] = {1, 2, 3, 4, 5};
		List<List<Integer>> result = obj.getEquivalents(nums);
		
		for(List<Integer> list : result){
			System.out.println("");
			for(Integer innerList : list){
				System.out.print(innerList + " ");
			}
		}
	}
}
