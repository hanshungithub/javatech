package cn.hassan.lambda.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 10:29
 * Description:
 */
public class AppleGreenColorPredicate implements ApplePredicate {
	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals("green");
	}
}
