
public class TwoSumII_ArraySorted {

	public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers.length == 0){
            return result;
        }
        
        for(int out=0; out < numbers.length; out++){
            for(int in=out+1; in < numbers.length; in++){
                if((numbers[out] + numbers[in]) == target){
                    result[0] = out + 1;
                    result[1] = in + 1;
                    return result;
                }
                if(numbers[in] > target){
                	break;
                }
            }
        }
        return result;
    }
	
	public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers.length == 0){
            return result;
        }
        
        int leftPtr = 0;
        int rightPtr = numbers.length - 1;
        
        while(numbers[rightPtr] > target){
        	rightPtr--;
        }
        
        for(int out=leftPtr; out <= rightPtr ; out++){
            for(int in=out+1; in <= rightPtr; in++){
                if((numbers[out] + numbers[in]) == target){
                    result[0] = out + 1;
                    result[1] = in + 1;
                    return result;
                }
            }
        }
        return result;
    }
	
	// Perfect solution
	public int[] twoSum2(int[] num, int target){
		int[] indice = new int[2];
	    if (num == null || num.length < 2) return indice;
	    int left = 0, right = num.length - 1;
	    while (left < right) {
	        int v = num[left] + num[right];
	        if (v == target) {
	            indice[0] = left + 1;
	            indice[1] = right + 1;
	            break;
	        } else if (v > target) {
	            right --;
	        } else {
	            left ++;
	        }
	    }
	    return indice;
	}
	
	public static void main(String[] args) {
		int[] numbers = {5, 25, 75};
		//int[] numbers = {-3,3,4,90};
		
				
		
		int target = 100;
		TwoSumII_ArraySorted obj = new TwoSumII_ArraySorted();
		int[] result = obj.twoSum2(numbers, target);
		System.out.println(result[0] + "  " + result[1]);
	}
}
