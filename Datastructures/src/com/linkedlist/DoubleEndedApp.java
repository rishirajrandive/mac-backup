package com.linkedlist;

public class DoubleEndedApp {

	public static void main(String[] args) {
		DoubleEndedList theList = new DoubleEndedList();
		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);
		theList.displayLinkList(); // display the list
		theList.deleteFirst(); // delete first two items
		theList.deleteFirst();
		theList.displayLinkList();
	}
}
