package cn.hassan.lambda.t1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/23 10:31
 * Description:
 */
public class AppleTest {

	@Test
	public void test01() {
		List<Apple> apples = new ArrayList<>();

		//使用匿名函数
		List<Apple> apples1 = filterApples(apples, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return false;
			}
		});

		//使用lambda表达式
		List<Apple> apples2 = filterApples(apples, (Apple apple) -> "red".equals(apple.getColor()));

		//方法引用
		apples.sort(Comparator.comparing(Apple::getWeight));
	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
		List<Apple> resule = new ArrayList<>();
		for (Apple apple : inventory) {
			if(predicate.test(apple)){
				resule.add(apple);
			}
		}
		return resule;
	}


}
