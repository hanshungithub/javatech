package cn.hassan.designpattern.factory.normal;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/7 8:40
 * Description:
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	abstract Pizza createPizza(String type);
}
