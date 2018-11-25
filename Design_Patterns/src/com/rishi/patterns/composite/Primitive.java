package com.rishi.patterns.composite;

public class Primitive implements Component{

	private int value;

    public Primitive(int val) {
        value = val;
    }

    public void traverse() {
        System.out.print( value + "  " );
    }
}