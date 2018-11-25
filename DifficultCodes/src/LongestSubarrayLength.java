
public class LongestSubarrayLength {

	public static int atMostSum(int arr[], int k) {
		int tempSum = 0;
		int count = 0;
		int maxCount = 0;
		int length = arr.length;
		
		for (int i = 0; i < length; i++) {

			if ((tempSum + arr[i]) <= k) {
				tempSum += arr[i];
				count++;
			}else if (tempSum != 0) {
				tempSum = tempSum - arr[i - count] + arr[i];
			}
			
			maxCount = Math.max(count, maxCount);
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
		System.out.println(atMostSum(arr, 4));
	}
}
