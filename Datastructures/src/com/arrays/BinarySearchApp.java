package com.arrays;

public class BinarySearchApp {

	public static void main(String[] args) {
		int max = 100;
		BinarySearch arr = new BinarySearch(max);
		
		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		int searchKey = 54; // search for item
		if( arr.find(searchKey) != arr.size() )
		System.out.println("Found " + searchKey);
		else
		System.out.println("Can’t find " + searchKey);
		arr.display(); // display items
		arr.delete(00); // delete 3 items
		arr.delete(55);
		arr.delete(99);
		arr.display();
	}
}
