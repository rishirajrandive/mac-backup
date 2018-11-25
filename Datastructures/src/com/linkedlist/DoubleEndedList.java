package com.linkedlist;

public class DoubleEndedList {

	private Link first;
	private Link last;
	
	public DoubleEndedList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void insertFirst(double val){
		Link newLink = new Link(val);
		
		if(isEmpty()){
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(double val){
		Link newLink = new Link(val);
		
		if(isEmpty()){
			first = newLink;
		}else{
			last.next = newLink;
		}
		last = newLink;
	}
	
	public Link deleteFirst(){
		Link current = first;
		
		if(first.next == null){
			last = null;
		}
		first = first.next;
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
}
