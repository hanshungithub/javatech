package cn.hassan.designpattern.strategy;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/28 7:55
 * Description:
 */
public class FlyWithWings implements FlyBehavoir {
	@Override
	public void fly() {
		System.out.println("I'm flying");
	}
}
