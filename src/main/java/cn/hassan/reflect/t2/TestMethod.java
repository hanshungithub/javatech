package cn.hassan.reflect.t2;

import org.junit.jupiter.api.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/28 10:34
 * Description:
 */
public class TestMethod {

	@Test
	public void testOne() {
		Student zhangsan = new Student("sherry", 18, 89d);
		String str = SimpleMapper.toString(zhangsan);
		System.out.println(str);
		Student zhangsan2 = (Student) SimpleMapper.fromString(str);
		System.out.println(zhangsan2);
	}
}
