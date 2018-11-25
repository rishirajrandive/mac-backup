package com.rishi.patterns.composite;

public class Row extends Composite{
	public Row(int val) {
        super(val);
    }

    public void traverse() {
        System.out.print("Row");
        super.traverse();
    }
}
