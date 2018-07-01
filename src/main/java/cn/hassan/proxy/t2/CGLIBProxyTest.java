package cn.hassan.proxy.t2;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 18:50
 * Description:
 */
public class CGLIBProxyTest {

    @Test
    public void testOne() {
        RealService instance = (RealService)ProxyContainer.getInstance(RealService.class);
        instance.sayHello();
    }
}
