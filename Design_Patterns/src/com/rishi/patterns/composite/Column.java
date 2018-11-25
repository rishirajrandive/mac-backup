package com.rishi.patterns.composite;

public class Column extends Composite{

	public Column(int val) {
        super(val);
    }

    public void traverse() {
        System.out.print("Col");
        super.traverse();
    }
}
