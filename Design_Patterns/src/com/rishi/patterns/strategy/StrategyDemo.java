package com.rishi.patterns.strategy;


/**
 * Define the interface of an interchangeable family of algorithms
 * Bury algorithm implementation details in derived classes
 * Derived classes could be implemented using the Template Method pattern
 * Clients of the algorithm couple themselves strictly to the interface
 * 
 * @author rishi
 *
 */
//4. Clients couple strictly to the interface
public class StrategyDemo {
	 // client code here
    private static void execute(Strategy strategy) {
        strategy.solve();
    }

    public static void main( String[] args ) {
        Strategy[] algorithms = {new Foo(), new Bar()};
        for (Strategy algorithm : algorithms) {
            execute(algorithm);
        }
    }
}
