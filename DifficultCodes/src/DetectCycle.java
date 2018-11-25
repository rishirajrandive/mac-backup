import java.util.HashSet;

public class DetectCycle {

	public static ListNode detectCycle(ListNode A){
		if(A == null){
			return null;
		}
		
		HashSet<ListNode> set = new HashSet<>();
		while(A!= null){
			if(set.contains(A)){
				return A;
			}else {
				set.add(A);
			}
			A = A.next;
		}
		return null;
	}
}

class ListNode{
	public int val;
	public ListNode next;
	
	public ListNode(int v){
		val = v;
		next = null;
	}
}