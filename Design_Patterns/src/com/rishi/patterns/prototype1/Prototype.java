package com.rishi.patterns.prototype1;

public interface Prototype {
	Prototype clone();
    String getName();
    void execute();
}
