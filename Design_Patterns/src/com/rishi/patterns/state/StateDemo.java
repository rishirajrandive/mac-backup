package com.rishi.patterns.state;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Chain is our wrapper class which has the current state object
 * State is our base state with default implementation of method and takes additional parameter of wrapper class
 * Chain our wrapper class delegates the action to current state
 * Rest are the states
 * @author rishi
 *
 */
public class StateDemo {
	public static void main( String[] args ) throws IOException {
        InputStreamReader is = new InputStreamReader( System.in );
        Chain chain = new Chain();
        while (true) {
            System.out.print( "Press 'Enter'" );
            is.read();
            chain.pull();
        }
    }
}
