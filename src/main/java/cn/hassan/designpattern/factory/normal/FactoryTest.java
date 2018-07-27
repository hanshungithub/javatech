package cn.hassan.designpattern.factory.normal;


import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/8 7:27
 * Description:
 */
public class FactoryTest {

	@Test
	public void test01() {
		PizzaStore nyStore = new NYStylePizzStore();
		PizzaStore chicagoStore = new ChicageStylePizzStore();

		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName());

		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName());

	}
}
