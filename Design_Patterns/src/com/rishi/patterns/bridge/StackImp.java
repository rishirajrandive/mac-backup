package com.rishi.patterns.bridge;

public interface StackImp {

	Object push(Object o);
    Object peek();
    boolean empty();
    Object pop();
}
