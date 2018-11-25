/**
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * Bit manipuplation notes:
 * ~ NOT
 * & AND
 * | OR
 * ^ EXOR
 * a << b Left shift a by b
 * a >> b Right shift a by b
 * 1. Power of two
 * 	If a number is power of 2 and NOT zero, the bit representation of this number will
 * have only ONE bit as 1. Let the number be X, so X & X-1, should give us 0, if X is 
 * power of 2. Bit representation of X-1 can be obtained by flipping all the bits to 
 * right of rightmost 1, including 1.
 * Ex: 4 = 100, 3 = 011, hence X & X-1 => 100 & 011 = 000 (4 is power of 2)
 * 
 * 2. 2^n can be represented by 1 << n
 * 
 * 3. Check if ith bit is set or not in a number:
 * 	Perform & operation with 2^i. Ex: To check if 1st (starting from 0) bit set of 4 (100)
 *  here i=1, 4 & (1 << i) => 100 & 010 => 0, hence not set.
 * 
 * 4. Generate possible subsets of a set:
 * 		Ex: Check the method possibleSubsets() below. 
 * 
 * 5. If all the bits of number are 1, then number is 2^i - 1 (i is total number of i)
 * 
 * 6. Find the largest power of 2 (most significant bit in binary form) which is less that or equal to 
 * N.
 * 		See largestPower() below with explanation.
 *  
 * @author rishi
 *
 */
public class IntegerReplacement {
	 public int integerReplacement(int n) {
		 int count = 0;
		 long num = n;
		 while(num > 3){
			 if((num & 1) != 0 && (num & 1<<1) != 0){
				 System.out.println("This is n+1");
		        	num = num + 1;
			 }
			 else if((num & 1) != 0){
	        	System.out.println("This is n-1");
	        	num = num - 1;
			 }else {
	        	System.out.println("This is n/2");
	        	num = num/2;
			 }
			 count++;
		 }
		 if(num == 3){
			 count = count + 2;
		 }else if(num == 2){
			 count = count + 1;
		 }
        return count;
    }
	 
	 public static void possibleSubsets(char[] A){
		 int n = A.length;
		 for(int i=0; i< (1 << n); i++){
			 for(int j=0; j<n; j++){
				 if((i & (1 << j)) == 0){
					 System.out.print(A[j] + " ");
				 }
			 }
			 System.out.println("");
		 }
	 }
	 
	 /**
	  * Ex: For 21 (10101) most significant bit is at 4th (from 0) so the largest power of 2
	  * possible is 2^4 = 16.
	  * This program first makes all the bit to right of most significant bit to 1. 
	  * Right now the program supports till 2^16, 16 bits. Once all the bits are converted to 1
	  * Right shift by 1 to n+1.
	  * So for 21, after changing bits to 1 we get, 31 (11111), so 31+1 = 32 (100000), right shift 32
	  * we get 16 (10000) is the answer
	  * @param n
	  */
	 public static void largestPower(int n){
		 n = n | (n>>1);
		 n = n | (n>>2);
		 n = n | (n>>4);
		 n = n | (n>>8);
		 int power = (n+1)>>1;
		 System.out.println("Largest power of is " + power);
	 }
	 
	 public static void main(String[] args) {
		IntegerReplacement obj = new IntegerReplacement();
		System.out.println("Min replacements required = " + obj.integerReplacement(2147483647));
		char[] arr = {'a', 'b', 'c'};
		possibleSubsets(arr);
		largestPower(256);
	}
}
