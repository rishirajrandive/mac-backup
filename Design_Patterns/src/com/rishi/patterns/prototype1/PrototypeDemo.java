package com.rishi.patterns.prototype1;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a "contract" with clone() and getName() entries
 * Design a "registry" that maintains a cache of prototypical objects
 * Populate the registry with an initializePrototypes() function
 * The registry has a findAndClone() "virtual constructor" that can transform a String into its correct object (it calls clone() which then calls "new")
 * All classes relate themselves to the clone() contract
 * Client uses the findAndClone() virtual ctor instead of the "new" operator

 * @author rishi
 *
 */
public class PrototypeDemo {

	public static void main(String[] args) {
        if (args.length > 0) {
            initializePrototypes();
            List<Prototype> prototypes = new ArrayList<>();
            // 6. Client does not use "new"
            for (String protoName : args) {
                Prototype prototype = PrototypeModule.createPrototype(protoName);
                if (prototype != null) {
                    prototypes.add(prototype);
                }
            }
            for (Prototype p : prototypes) {
                p.execute();
            }
        } else {
            System.out.println("Run again with arguments of command string ");
        }
    }

    // 3. Populate the "registry"
    public static void initializePrototypes() {
        PrototypeModule.addPrototype(new PrototypeAlpha());
        PrototypeModule.addPrototype(new PrototypeBeta());
        PrototypeModule.addPrototype(new ReleasePrototype());
    }
}
