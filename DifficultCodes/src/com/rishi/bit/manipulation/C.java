package com.rishi.bit.manipulation;

public class C {

	public static void main(String[] args) {
		A obj = new B();
		obj.print();
		B obj1 = new B();
		obj1.print();
		System.out.println(1%4);
	}
	
	public class Foo implements Comparable<Foo>{
		int bar;
		String blah;
		
		@Override
		public int compareTo(Foo o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
