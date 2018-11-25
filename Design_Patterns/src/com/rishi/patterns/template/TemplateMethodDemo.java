package com.rishi.patterns.template;

/**
 * Standardize the skeleton of an algorithm in a base class "template" method
 * Common implementations of individual steps are defined in the base class
 * Steps requiring peculiar implementations are "placeholders" in base class
 * Derived classes can override placeholder methods
 * Derived classes can override implemented methods
 * Derived classes can override and "call back to" base class methods

 * @author rishi
 *
 */
public class TemplateMethodDemo {
	public static void main(String[] args) {
        Generalization algorithm = new Realization();
        algorithm.findSolution();
    }
}
