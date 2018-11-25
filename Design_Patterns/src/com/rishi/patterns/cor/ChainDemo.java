package com.rishi.patterns.cor;

/**
 * Passes the executing to next in chain, we don't know which one is the handler.
 * Do not use when request is handled by only one handler always
 * @author rishi
 *
 */
public class ChainDemo {
	public static void main(String[] args) {
		Handler rootChain = new Handler();
		rootChain.add(new Handler());
		rootChain.add(new Handler());
		rootChain.add(new Handler());
		rootChain.wrapAround(rootChain);
		for (int i = 1; i < 6; i++) {
			System.out.println("Operation #" + i + ":");
			rootChain.execute(i);
			System.out.println();
		}
	}
}
