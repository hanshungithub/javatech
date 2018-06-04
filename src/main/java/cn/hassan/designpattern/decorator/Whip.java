package cn.hassan.designpattern.decorator;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/4 7:34
 * Description: 具体装饰纸
 */
public class Whip extends CondimentDecorator {

	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Whip";
	}

	@Override
	double cost() {
		return 0.50 + beverage.cost();
	}
}
