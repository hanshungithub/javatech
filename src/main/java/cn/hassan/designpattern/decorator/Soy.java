package cn.hassan.designpattern.decorator;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/4 7:34
 * Description: 具体装饰纸
 */
public class Soy extends CondimentDecorator {

	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Soy";
	}

	@Override
	double cost() {
		return 0.30 + beverage.cost();
	}
}
