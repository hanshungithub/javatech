package cn.hassan.designpattern.strategy.impl;

import cn.hassan.designpattern.strategy.FlyBehavoir;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/28 7:55
 * Description:
 */
public class FlyNoWay implements FlyBehavoir {
	@Override
	public void fly() {
		System.out.println("I can't fly");
	}
}
