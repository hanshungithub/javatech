package cn.hassan.designpattern.factory.normal;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/7 17:26
 * Description:
 */
public class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		list.add("Shredded Mozzarella Cheese");
	}

	void cut() {
		System.out.println("Cutting the pozza into square slices");
	}
}
