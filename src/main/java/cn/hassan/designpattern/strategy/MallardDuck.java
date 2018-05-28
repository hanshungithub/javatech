package cn.hassan.designpattern.strategy;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/28 8:21
 * Description:
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavoir = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		System.out.println("this is a mallard duck");
	}
}
