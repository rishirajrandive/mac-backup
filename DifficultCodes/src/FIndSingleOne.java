import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FIndSingleOne {

	public static int getSingleOne(final List<Integer> a){
		if(a.size() == 0){
			return 0;
		}
		
		a.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for(int i=0; i<a.size(); i=i+2){
			if((i+1) < a.size() && a.get(i) != a.get(i+1)){
				return a.get(i);
			}
			if(i == a.size() - 1){
				return a.get(i);
			}
		}
		return 0;
	}
	
	public static int findSingleOne(List<Integer> A){
		 int num = 0;
		    
		    for (int val : A) {
		        num ^= val;
		    }
		    
		    return num;
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(1);
		arr.add(3);
		arr.add(5);
		arr.add(5);
		System.out.println(getSingleOne(arr));
		System.out.println(findSingleOne(arr));
	}
}
