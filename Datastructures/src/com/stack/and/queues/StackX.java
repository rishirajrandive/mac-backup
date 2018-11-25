package com.stack.and.queues;

public class StackX {

	private long stackArray[];
	private char charArray[];
	private int maxSize;
	private int top;
	private int charMaxSize;
	private int charTop;
	
	public void initCharArray(int size){
		charMaxSize = size;
		charArray = new char[charMaxSize];
		charTop = -1;
	}
	
	public void initArray(int size){
		maxSize = size;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long val){
		stackArray[++top] = val;
	}
	
	public void pushChar(char val){
		charArray[++charTop] = val;
	}
	
	public long pop(){
		return stackArray[top--];
	}
	
	public char popChar(){
		return charArray[charTop--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public char peekChar(){
		return charArray[charTop];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isEmptyChar(){
		return charTop == -1;
	}
	
	public boolean isFull(){
		return top == maxSize-1;
	}
	
	public boolean isFullChar(){
		return charTop == charMaxSize-1;
	}
}
