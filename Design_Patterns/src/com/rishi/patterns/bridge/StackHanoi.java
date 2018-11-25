package com.rishi.patterns.bridge;

public class StackHanoi extends Stack{

	private int totalRejected = 0;

    public StackHanoi() {
        super("java");
    }

    public StackHanoi(String s) {
        super(s);
    }

    public int reportRejected() {
        return totalRejected;
    }

    public void push(int in) {
        if (!imp.empty() && in > (Integer)imp.peek()) {
            totalRejected++;
        } else {
            imp.push(in);
        }
    }
}
