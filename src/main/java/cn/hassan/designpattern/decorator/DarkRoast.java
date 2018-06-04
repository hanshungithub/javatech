package cn.hassan.designpattern.decorator;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/4 7:47
 * Description:
 */
public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}

	@Override
	double cost() {
		return 1.50;
	}
}
