package cn.hassan.designpattern.decorator;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/4 7:28
 * Description: 被装饰者
 */
public class Espresso extends Beverage {

	public Espresso() {
		description = "Espressp";
	}

	@Override
	double cost() {
		return 1.99;
	}

}
