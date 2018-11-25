package com.rishi.patterns.state;

public class Medium extends State{
	public void pull(Chain wrapper) {
        wrapper.setState(new High());
        System.out.println("   high speed");
    }
}
