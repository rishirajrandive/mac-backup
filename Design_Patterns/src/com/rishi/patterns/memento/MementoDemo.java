package com.rishi.patterns.memento;

/**
 * Whenever we call addMemento(), current state is saved.
 * So when we restore it we get the last saved state, right now the code has hardcoded 1
 * However, we can change that.
 * @author rishi
 *
 */
public class MementoDemo {
	public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("State1");
        originator.setState("State2");
        caretaker.addMemento( originator.save() );
        originator.setState("State3");
        caretaker.addMemento( originator.save() );
        originator.setState("State4");
        originator.restore( caretaker.getMemento() );
    }
}
