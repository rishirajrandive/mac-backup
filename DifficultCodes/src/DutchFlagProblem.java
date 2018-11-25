
/**
 * Problem is about clubbing the same values together in a sorted way. Usually for 
 * 3 different type of value.
 * 
 * Moves around mid value. There could be 3 cases:
 * 1. We hit low: Swap the mid and low values in array and increment both.
 * 2. We hit mid: Increment mid.
 * 3. We hit high: Swap the high and mid value, decrement high.
 * 
 * Continue this till mid <= high
 * @author rishi
 *
 */
public class DutchFlagProblem {

	public int[] dutchFlag(int[] nums){
		int low = 0;
		int mid = 0;
		int high = nums.length-1;
		int temp = 0;
		
		while(mid <= high){
			switch(nums[mid]){
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
				break;
			}
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		int nums[] = {1, 0, 2, 1, 0, 0, 0, 0, 1, 1, 1, 0, 2, 1, 2, 1, 0};
		DutchFlagProblem obj = new DutchFlagProblem();
		int[] result = obj.dutchFlag(nums);
		
		for(int i=0; i<result.length; i++){
			System.out.print(result[i] + " ");
		}
	}

}
