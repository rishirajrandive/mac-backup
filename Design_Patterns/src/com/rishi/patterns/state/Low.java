package com.rishi.patterns.state;

public class Low extends State{
	public void pull(Chain wrapper) {
        wrapper.setState(new Medium());
        System.out.println("   medium speed");
    }
}
