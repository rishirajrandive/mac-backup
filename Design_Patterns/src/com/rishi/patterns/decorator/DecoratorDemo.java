package com.rishi.patterns.decorator;

/**
 * Create a "lowest common denominator" that makes classes interchangeable
 * Create a second level base class for optional functionality
 * "Core" class and "Decorator" class declare an "isa" relationship
 * Decorator class "has a" instance of the "lowest common denominator"
 * Decorator class delegates to the "has a" object
 * Create a Decorator derived class for each optional embellishment
 * Decorator derived classes delegate to base class AND add extra stuff
 * Client has the responsibility to compose desired configurations
 * 
 * @author rishi
 *
 */
public class DecoratorDemo {

	public static void main(String[] args) {
        // 8. Client has the responsibility to compose desired configurations
        Widget widget = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField(80, 24))));
        widget.draw();
    }
}

