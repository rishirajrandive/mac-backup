package com.rishi.patterns.abstractfactory;

/**
 * Here, the factory is for CPU and MMU. There are two different types of CPUs and MMUs.
 * 
 * {@link AbstractFactory} decides how the CPU should be manufactured.
 * We just need to specify the {@link Architecture}
 *   
 * @author rishi
 *
 */
public class Client {
	public static void main(String[] args) {
		AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
		CPU cpu = factory.createCPU();
		MMU mmu = factory.createMMU();
	}
}
