package cn.hassan.designpattern.strategy;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/28 8:14
 * Description: 抽象基类
 */
public abstract class Duck {
	FlyBehavoir flyBehavoir;
	QuackBehavior quackBehavior;

	abstract void display();

	public void performFly() {
		flyBehavoir.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("all ducks float,even decoys");
	}
}
