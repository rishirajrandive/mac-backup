package com.rishi.patterns.nullobject;

public class NullObjectDemo {
	public static void main(String[] args) {
		Application app = new Application(new NullPrintStream());
		app.doSomething();
	}
}
