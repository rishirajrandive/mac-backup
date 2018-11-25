
public class JumpGame {

	public boolean canJump(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return true;
        }
        int start = nums[0];
        for(int i=1; i<length; i++){
            start--;
            if(start < 0){
            	return false;
            }
            if(start < nums[i]){
            	start = nums[i];
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		JumpGame obj = new JumpGame();
		//int[] nums = {2, 5, 0, 0};
		//int[] nums = {0, 2, 3};
		//int[] nums = {2, 0};
		//int[] nums = {1, 0};
		//int[] nums = {2, 0, 5, 0, 0, 1};
		int[] nums = {1, 3, 1, 4, 2, 3, 5, 4};
		System.out.println(obj.canJump(nums));
	}
}
