import java.util.ArrayList;
import java.util.Collections;

public class MiceAndHoles {

	 public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
	        if (A == null || B == null)
	            return 0;
	            
	        Collections.sort(A);
	        Collections.sort(B);
	        
	        int max = 0;
	        int n = A.size();
	        
	        for (int i = 0; i < n; i++) {
	            max = Math.max(max, Math.abs(A.get(i) - B.get(i)));
	        }
	        
	        return max;
	    }
	 
	 public static void main(String[] args) {
		MiceAndHoles obj = new MiceAndHoles();
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		A.add(4);
		A.add(-4);
		A.add(2);
		
		B.add(4);
		B.add(0);
		B.add(5);
		System.out.println(obj.mice(A, B));
	}
}
