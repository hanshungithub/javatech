package cn.hassan.designpattern.factory;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/7 15:05
 * Description:
 */
public class NYStylePizzStore extends PizzaStore {
	@Override
	Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizze();
		}
		return null;
	}
}
