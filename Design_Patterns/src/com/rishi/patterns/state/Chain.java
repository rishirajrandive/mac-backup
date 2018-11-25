package com.rishi.patterns.state;

public class Chain {
	 private State current;

	    public Chain() {
	        current = new Off();
	    }

	    public void setState(State state) {
	        current = state;
	    }

	    public void pull() {
	        current.pull(this);
	    }
}
