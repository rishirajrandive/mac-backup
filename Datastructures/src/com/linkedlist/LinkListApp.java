package com.linkedlist;

public class LinkListApp {

	public static void main(String[] args) {
		LinkList theList = new LinkList(); // make new list
		theList.insertFirst(2.99); // insert four items
		theList.insertFirst(4.99);
		theList.insertFirst(6.99);
		theList.insertFirst(8.99);
		theList.displayLinkList(); // display list
		
		/** Below is deletion code from first **/
//		while( !theList.isEmpty()){ // until it’s empty,
//			Link aLink = theList.deleteFirst(); // delete link
//			System.out.print("Deleted "); // display it
//			aLink.displayLink();
//			System.out.println("");
//		}
		
		Link find = theList.find(6.99);
		if(find != null){
			System.out.println("Found the key " + find.data);
		}else{
			System.out.println("Not found");
		}
		
		Link delete = theList.deleteAtKey(4.99);
		if(delete != null){
			System.out.println("Deleted the key " + delete.data);
		}else{
			System.out.println("Not found");
		}
		theList.displayLinkList();
	}
}
