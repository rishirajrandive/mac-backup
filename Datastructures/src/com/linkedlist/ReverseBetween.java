package com.linkedlist;

/**
 * Corner cases would be
 * 1. Both m and n same
 * 2. m and n are consecutive
 * 3. Entire length
 * 4. m is start of length
 * 5. n is end of length
 * @author rishi
 *
 */
public class ReverseBetween {

	public static void main(String[] args) {
		ReverseBetween obj = new ReverseBetween();
		LinkList theList = new LinkList(); // make new list
		theList.insertFirst(5);
		theList.insertFirst(4);
		theList.insertFirst(3);
		theList.insertFirst(2);
		theList.insertFirst(1);
		theList.displayLinkList(); // display list
		
		theList.displayLinkList(obj.reverseBetween(theList.first, 1, 5));
	}
	
	public Link reverseBetween(Link head, int m, int n) {
        Link currNode = head;
        Link nextNode = null;
        Link prevNode = null;
        Link tempHead = head;
        Link prevHead = null;
        
        if(currNode.next == null || m == n){
            return head;
        }
        
        int counter = 1;
        
        while(counter <= n && currNode != null){
            if(counter >= m){
                nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
            }else{
                currNode = currNode.next;
                prevHead = tempHead;
                tempHead = currNode;
            }
            counter++;
        }
        
        if(head.next == null){
            head.next = currNode;
            head = prevNode;
        }else {
        	prevHead.next = prevNode;
        	tempHead.next = currNode;
        }
        return head;
    }
}
