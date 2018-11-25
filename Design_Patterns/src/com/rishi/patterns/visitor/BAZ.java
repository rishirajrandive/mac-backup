package com.rishi.patterns.visitor;

public class BAZ implements Element{
	public void accept(Visitor v) {
        v.visit(this);
    }

    public String getBAZ() {
        return "BAZ";
    }
}
