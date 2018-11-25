package com.rishi.patterns.observer;

public abstract class Observer {
	protected Subject subject;
    public abstract void update();
}
