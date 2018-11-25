package spring2017;

public class RemoveAllDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode node1 = dummyHead;
        
        while(node1.next != null){
            ListNode node2 = node1.next;
            
            while(node2.next != null && node2.next.val == node2.val){
                node2 = node2.next;
            }
            if(node2 != node1.next){
                node1.next = node2.next;
            }else {
                node1 = node1.next;
            }
        }
        return dummyHead.next;
    }
}
