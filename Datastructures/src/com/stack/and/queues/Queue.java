package com.stack.and.queues;

/**
 * Queue class without counting number of items. If we are keeping count of 
 * number of item on insert and remove then isEmpty, isFull and size functions
 * are much easier to implement.
 * 
 * insertPrority() - shows how elements are inserted in Priority Queue.
 * @author rishi
 *
 */
public class Queue {

	private int maxSize;
	private long[] queueArray;
	private int front;
	private int rear;
	
	public Queue(int size){
		maxSize = size + 1;
		queueArray = new long[maxSize];
		front = 0;
		rear = -1;
	}
	
	public void insert(long val){
		if(rear == maxSize-1){
			rear = -1;
		}
		queueArray[++rear] = val;
	}
	
	public void insertPriority(long val){
		int i;
		
		if(rear == maxSize-1){
			rear = -1;
		}
		
		if(isEmpty()){
			insert(val);
		}else{
			for(i=rear; i>=0; i--){
				if(val > queueArray[i]){
					queueArray[i+1] = queueArray[i];
				}else{
					break;
				}
			}
			queueArray[i+1] = val;
			++rear;
		}
	}
	
	public long remove(){
		long temp = queueArray[front++];
		if(front == maxSize -1){
			front = 0;
		}
		return temp;
	}
	
	public long peek(){
		return queueArray[front];
	}
	
	public boolean isEmpty(){
		return (rear+1 == front || front+maxSize-1 == rear);
	}
	
	public boolean isFull(){
		return (rear+2 == front || front+maxSize-2 == rear);
	}
	
	public int size(){
		if(rear >= front){
			return rear-front+1;
		}else {
			return (maxSize-1) + (rear + 1);
		}
	}
}
