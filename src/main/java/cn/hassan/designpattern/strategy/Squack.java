package cn.hassan.designpattern.strategy;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/28 8:13
 * Description:
 */
public class Squack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Squack");
	}
}
