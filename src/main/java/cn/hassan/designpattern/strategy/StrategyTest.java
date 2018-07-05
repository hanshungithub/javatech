package cn.hassan.designpattern.strategy;

import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/5/29 7:19
 * Description:
 */
public class StrategyTest {

	@Test
	public void test01() {
		Duck duck = new MallardDuck();
		duck.performFly();
		duck.performQuack();
	}
}
