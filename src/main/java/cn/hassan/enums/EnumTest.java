package cn.hassan.enums;

import org.junit.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/23 9:25
 * Description:
 */
public class EnumTest {

	@Test
	public void testOne() {
		Size xxm = Size.fromAbbr("L");
		Size[] values = Size.values();
		for (Size value : values) {
			//System.out.println(value.getAbbr());
			//System.out.println(value.getTitle());
		}
		Size large = Size.LARGE;
		System.out.println(large);
	}
}
