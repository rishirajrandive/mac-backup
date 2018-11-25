package com.rishi.patterns.abstractfactory;

public abstract class AbstractFactory {
	private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
            case EMBER:
                factory = EMBER_TOOLKIT;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}

