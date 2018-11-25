import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.spi.ResolveResult;

public class TopKFrquent {

	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valueCounts = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(valueCounts.containsKey(nums[i])){
                valueCounts.put(nums[i], valueCounts.get(nums[i])+1);
            }else{
                valueCounts.put(nums[i], 1);
                valueCounts.put(nums[i], valueCounts.getOrDefault(nums[i], 1) + 1);
            }
        }
        
        Object[] vals = valueCounts.values().toArray();
        Arrays.sort(vals);
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<k; i++){
        	for(Entry<Integer, Integer> entry: valueCounts.entrySet()){
        		if(entry.getValue() == (Integer)vals[vals.length - 1 -i]){
        			result.add(entry.getKey());
        			break;
        		}
        	}
        	valueCounts.remove(result.get(i));
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		TopKFrquent obj = new TopKFrquent();
		int[] nums = {1,2};
		List<Integer> result = obj.topKFrequent(nums, 2);
		System.out.println(result.size());
		for(int i=0; i<2; i++){
			System.out.print(result.get(i) + " ");
		}
	}
}
