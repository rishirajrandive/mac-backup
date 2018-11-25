import java.util.Arrays;

/**
 * Entire sort algo could be replaced by simple, Array.sort(nums);
 * @author rishi
 *
 */
public class MaxGap {

	public int maximumGap1(int[] nums){
		int length = nums.length;
	    if(length < 2){
	        return 0;
	    }
	    int maxGap = 0;
	    
	    Arrays.sort(nums);
	    
	    for(int i=0; i<length; i++){
	    	if(i>0 && maxGap < (nums[i] - nums[i-1])){
	    		maxGap = nums[i] - nums[i-1];
	    	}
	    }
	    return maxGap;
	}
	
	public int maximumGap(int[] nums){
	    int length = nums.length;
	    if(length < 2){
	        return 0;
	    }
	    int min = 0;
	    int maxGap = 0;
	    
	    for(int out=0; out<length; out++){
	        min = out;
	        for(int in=out+1; in<length; in++){
	            if(nums[in] < nums[min]){
	                min = in;
	            }
	        }
	        
	        if(min != out){
	            int temp = nums[min];
	            nums[min] = nums[out];
	            nums[out] = temp;
	        }
	        
	        if(out > 0 && maxGap < (nums[out] - nums[out-1])){
	            maxGap = nums[out] - nums[out-1];
	        }
	    }
	    return maxGap;
	}
	
	public static void main(String[] args) {
		int[] nums = {15, 1, 20, 12, 4};
		//int[] nums = {15, 1};
		//int[] nums = {0, 15};
		//int[] nums = {15};
		
		MaxGap obj = new MaxGap();
		System.out.println("Maximu gap " + obj.maximumGap1(nums));
	}
}
