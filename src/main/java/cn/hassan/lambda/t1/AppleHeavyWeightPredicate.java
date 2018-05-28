package cn.hassan.lambda.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 10:27
 * Description:
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}
