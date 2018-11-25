package com.linkedlist;

public class Link {

	public double data;
	public Link next;
	public Link previous;
	
	public Link(double data){
		this.data = data;
		
	}
	
	public void displayLink(){
		System.out.print("{" + this.data + "}");
	}
}
