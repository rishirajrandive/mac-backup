package com.rishi.patterns.strategy;

public class Bar extends StrategySearch{
	 private int state = 1;

	    protected void preProcess()  {
	        System.out.print("PreProcess  ");
	    }

	    protected void postProcess() {
	        System.out.print("PostProcess  ");
	    }

	    protected boolean search() {
	        System.out.print("Search-" + state++ + "  ");
	        return state == 3 ? true : false;
	    }
}
