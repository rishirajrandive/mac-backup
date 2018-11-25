/**
 * Bottom up dynamic programming is used. 
 * We create a 2D matrix with values of balloon bursting sequence.
 * First filling the diagonal with the values of each element being bursted
 * at a time. 
 * @author rishi
 *
 */
public class BurstBalloons {

	public static int getMaxPoints(int[] nums){
		int burstMatrix[][] = new int[nums.length][nums.length];
	
		for(int len=1; len<=nums.length; len++){
			for(int i=0; i <= nums.length - len; i++){
				int j = i + len-1;
				for(int k=i; k <= j; k++){
					int leftValue = 1;
					int rightValue = 1;
					
					if(i != 0){
						leftValue = nums[i-1];
					}
					
					if(j != nums.length-1){
						rightValue = nums[j+1];
					}
					
					int before = 0;
					int after = 0;
					
					if(i != k){
						before = burstMatrix[i][k-1];
					}
					if(j != k){
						after = burstMatrix[k+1][j];
					}
					
					burstMatrix[i][j] = Math.max(before + (leftValue * nums[k] * rightValue) + after, burstMatrix[i][j]);
				}
			}
		}
		return burstMatrix[0][nums.length-1];
	}
	
	public static void main(String[] args) {
		int[] balloons = {3, 1, 5, 8};
		System.out.println("Maximum value is "+ getMaxPoints(balloons));
	}
}
