package spring2017;

public class ReverseLinkList {

	public ListNode reverseList(ListNode head, int m, int n){
		if(head == null || m == n){
			return head;
		}
		
		ListNode current = head;
		ListNode prev = null;
		ListNode lastLink = null;
		ListNode tempNodesHead = null;
		ListNode tempNodesLast = null;
		int counter = 1;
		while(current != null && counter <= n){
			if(counter >= m){
				ListNode newNode = new ListNode(current.val);
				if(tempNodesHead == null){
					tempNodesHead = newNode;
				}else {
					newNode.next = tempNodesHead;
					tempNodesHead = newNode;
				}
				if(tempNodesLast == null){
					tempNodesLast = newNode;
				}
				if(lastLink == null){
					lastLink = prev;
				}
				
			}
			prev = current;
			current = current.next;
			counter++;
		}
		lastLink.next = tempNodesHead;
		tempNodesLast.next = current;
		return lastLink;
	}
	
	public static void main(String[] args) {
		ReverseLinkList obj = new ReverseLinkList();
		int[] vals = {1, 2, 3, 4, 5};
		ListNode head = new ListNode(0);
		for(int i=vals.length-1; i>=0; i--){
			ListNode newNode = new ListNode(vals[i]);
			newNode.next = head;
			head = newNode;
		}
		ListNode node = obj.reverseList(head, 2, 4);
	}
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
