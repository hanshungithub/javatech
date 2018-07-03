package cn.hassan.proxy.t3;

import cn.hassan.annotation.t2.ServiceA;
import org.junit.jupiter.api.Test;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/3 8:08
 * Description:
 */
public class CGLIBTest {

	@Test
	public void testOne() {
		try {
			ServiceA instance = CGLIBContainer.getInstance(ServiceA.class);
			instance.callB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

