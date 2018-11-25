package com.rishi.patterns.abstractfactory1;

/**
 * Uses Factory method for creation through inheritance
 * and Prototype for creation through delegation.
 * Virtual constructor to defer choice to create until run-time.
 * @author rishi
 *
 */
public class FactoryFmProto {

	public static void main(String[] args) {
		AbstractFactory factory;
		int val = 1;
		if (val > 0) {
			factory = new PCFactory();
		} else {
			factory = new NotPCFactory();
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(factory.makePhase() + " ");
		}
		System.out.println();
		System.out.println(factory.makeCompromise());
		System.out.println(factory.makeGrade());
	}
}
