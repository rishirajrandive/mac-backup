package com.rishi.patterns.builder;

/**
 * Builder - has basic methods implemented and other methods required for pizza making abstract
 * Waiter - Our director, using builder creates the final product
 * 
 * @author rishi
 *
 */
public class PizzaBuilderDemo {

	public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        waiter.setPizzaBuilder( spicyPizzaBuilder );
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println(pizza.toString());
    }
}

