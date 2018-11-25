
public class NumSetBits {

	
	public static void main(String[] args) {
		long A = 5;
		int count = 0;
	    while (A > 0) {
	    	System.out.println("Condition" + (A&1));
	        if ( (A & 1) != 0)
	            count++;
	        A >>= 1;
	        System.out.println(A);
	    }
	}
}
