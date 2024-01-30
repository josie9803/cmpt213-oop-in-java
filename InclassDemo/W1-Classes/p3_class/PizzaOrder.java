package ca.cmpt213.p3_class;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class PizzaOrder {
	// Either "new" the ArrayList here, or in the constructor (ONLY ONCE!)
	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaOrder(int numPizzas) {
//		pizzas = new ArrayList<>();
	}
	
	public void printSizes() {
//		for (int i = 0; i < pizzas.size(); i++) {
//			Pizza currentPizza = pizzas.get(i);
		for (Pizza p : pizzas) {
			System.out.println("Area is " + p.calculateArea());
		}

		double minArea = getMinArea();
		System.out.println("Min area: " + minArea);
	}

	private double getMinArea() {
		//guard clause
		if (pizzas.size() == 0){
			throw new RuntimeErrorException("no pizza in list")
		}
		double minArea = pizzas.get(0);
		//double minArea = Double.MAX_VALUE;
		for (Pizza pizza : pizzas) {
			if (pizza.calculateArea() < minArea) {
				minArea = pizza.calculateArea();
			}
		}
		return minArea;
	}

	public int getNumberPizzas() {
		return pizzas.size();
	}

	public void add(Pizza pizza) {
		pizzas.add(pizza);
	}
}
