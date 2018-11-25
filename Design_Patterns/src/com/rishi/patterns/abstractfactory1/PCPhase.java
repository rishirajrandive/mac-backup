package com.rishi.patterns.abstractfactory1;

public class PCPhase extends Expression{

	private static int next = 0;
    private static final String[] list = {"\"animal companion\"", "\"vertically challenged\"",
            "\"factually inaccurate\"", "\"chronologically gifted\""};
    
	public PCPhase() {
		super(list[next]);
        next = (next + 1) % list.length;
	}
}
