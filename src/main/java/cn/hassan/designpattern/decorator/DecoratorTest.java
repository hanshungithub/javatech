package cn.hassan.designpattern.decorator;

import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/4 7:42
 * Description:
 */
public class DecoratorTest {

	@Test
	public void deoratorTest() {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + "￥" + beverage.cost());

		Beverage darkrost = new DarkRoast();
		darkrost = new Mocha(darkrost);
		darkrost = new Mocha(darkrost);
		darkrost = new Whip(darkrost);
		System.out.println(darkrost.getDescription() + "￥" + darkrost.cost());

		Beverage houseBlend = new HouseBlend();
		houseBlend = new Soy(houseBlend);
		houseBlend = new Mocha(houseBlend);
		houseBlend = new Whip(houseBlend);
		System.out.println(houseBlend.getDescription() + "￥"+ houseBlend.cost());
	}
}
