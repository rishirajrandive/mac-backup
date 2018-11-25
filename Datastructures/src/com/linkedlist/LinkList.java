package com.linkedlist;

/**
 * Insertion and deletion from first is O(1)
 * Whereas finding a particular key and then deleting it takes O(N) which is same
 * as an Array. However, if copying takes much longer than comparison then LinkedList
 * are much faster. Also it takes memory as much required.
 * 
 * Simple linked can be used to implement Stack by using insertFirst and deleteFirst
 * 
 * However to implement queues we will need to use double ended link list, then
 * insertLast and deleteFirst will make sure it's queue.
 * @author rishi
 *
 */
public class LinkList {

	public Link first;
	
	public LinkList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(double data){
		Link newLink = new Link(data);
		newLink.next = first;
		first = newLink;
	}
	
	public Link find(double key){
		Link current = first;
		while(current != null && current.data != key){
			current = current.next;
		}
		return current;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public Link deleteAtKey(double key){
		Link current = first;
		Link previous = first;
		
		while(current != null && current.data != key){
			previous = current;
			current = current.next;
		}
		
		if(current == first){
			first = first.next;
		}else{
			previous.next = current.next;
		}
		return current;
	}
	
	public void displayLinkList(){
		System.out.println("First to last list");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public void displayLinkList(Link node){
		System.out.println("First to last list");
		Link current = node;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}

