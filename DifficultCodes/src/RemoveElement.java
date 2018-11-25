
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int newLength = length;
        int j=length;
        for(int i=0; i<j; i++){
            if(nums[i] == val){
            	newLength--;
                for(j=j-1; j>i; j--){
                    if(nums[j] != val){
                    	int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }else{
                    	newLength--;
                    }
                }
                
            }
        }
        return newLength;
    }
	
	public int betterRemoveElement(int[] nums, int val){
		int index = 0;
		
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != val){
        		nums[index++] = nums[i];  
        	}
        }
        
        for(int i=0; i<nums.length; i++){
        	System.out.print(nums[i] + " ");
        }
        return index;
	}
	
	public static void main(String[] args) {
		//int[] nums = {1};
		//int[] nums = {3, 2, 2, 3};
		//int[] nums = {1, 2, 3, 4};
		//int[] nums = {0,4,4,0,4,4,4,0,2};
		int[] nums = {0,3,1,1,0,1,3,0,3,3,1,1};
		int val = 1;
		
		RemoveElement obj = new RemoveElement();
		//System.out.println("Array length " + obj.removeElement(nums, val));
		System.out.println("Better Array length " + obj.betterRemoveElement(nums, val));
	}
}
