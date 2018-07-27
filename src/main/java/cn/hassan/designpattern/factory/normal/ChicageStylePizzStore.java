package cn.hassan.designpattern.factory.normal;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/7 15:06
 * Description:
 */
public class ChicageStylePizzStore extends PizzaStore {
	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		}
		return null;
	}
}
