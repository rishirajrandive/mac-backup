package com.linkedlist;

public class DoublyLinkList {
	
	private Link first;
	private Link last;
	
	public DoublyLinkList(){
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
		}else{
			first.previous = newLink;
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
			newLink.previous = last;
		}
		last = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		// Assuming list is not empty		
		if(first.next == null){
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
	
	public Link deleteLast(){
		Link temp = last;
		// Assuming list is not empty
		if(first.next == null){
			first = null;
		}else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	
	public boolean insertAfter(double key, double val){
		Link current = first;
		
		while(current.data != key){
			current = current.next;
			if(current == null){
				return false;
			}
		}
		
		Link newLink = new Link(val);
		
		if(current == last){
			newLink.next = null;
			last = newLink;
		}else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}
	
	public Link deleteKey(double key){
		Link current = first;
		
		while(current.data != key){
			current = current.next;
			if(current == null){
				return null;
			}
		}
		
		if(current == first){
			first = current.next;
		}else{
			current.previous.next = current.next;
		}
		
		if(current == last){
			last = current.previous;
		}else{
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	public void displayForward(){
		System.out.println("List forward print");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public void displayBackward(){
		System.out.println("List backward print");
		Link current = last;
		while(current != null){
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}

}
