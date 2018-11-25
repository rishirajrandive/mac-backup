
public class JumpGameII {

	public static void main(String[] args) {
		//int[] nums = {2, 3, 1, 1, 4};
		//int[] nums = {1, 1};
		//int[] nums = {2, 1};
		//int[] nums = {1, 2};
		int[] nums = {1, 3, 1, 4, 2, 3, 5, 4};
		//int[] nums = {1,2,0,1};
		//int[] nums = {4,1,1,3,1,1,1};
		//int[] nums = {1, 2, 3};
		JumpGameII obj = new JumpGameII();
		System.out.println(nums.length);
		System.out.println("Min jumps required = "+ obj.correctJump(nums));
	}
	
	public int correctJump(int[] nums){
		if(nums.length <= 1){
			return 0;
		}
	        
        int currentBoundary = 0;
        int nextBoundary = 0;
        int steps = 0;
        
        for(int i=0;i < nums.length;i++ ){
            if(i > currentBoundary){
                currentBoundary = nextBoundary;
                ++steps;
            }
            
            if(i+nums[i] > nextBoundary){
                nextBoundary = i+nums[i];
            }   
        }    
        return steps;
	}
	
	public int jump(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return 0;
		}
		
		int length = nums.length - 1;
		int newLength = length;
		int jumps = 1;
		int steps = 0;
		int minJumps = length;
		
		for(int i=0; i<length; i++){
			newLength = length - i;
			jumps = i+1;
			
			for(int j=i; j<length; j=j+steps){
				steps = nums[j];
				if(steps == 0){
					steps = 1;
				}
				newLength = newLength - steps;
				if(newLength <= 1  && minJumps > jumps){
					minJumps = jumps;
				}else {
					jumps++;
				}
			}
		}
        return minJumps;
    }
}
