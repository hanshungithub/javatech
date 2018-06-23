package cn.hassan.generic;

import org.junit.jupiter.api.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/23 17:01
 * Description:
 */
public class Genetric {

	public static <T> T indexOf(T[] arr, T ele) {
		for (T t : arr) {
			if (t.equals(ele)) {
				return t;
			}
		}
		return null;
	}

	@Test
	public void testOne() {
		Integer[] num = new Integer[]{1, 2, 3, 4, 5, 6};
		Integer integer = indexOf(num, 3);
		System.out.println(integer);
	}
}
