package cn.hassan.annotation.t2;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 15:10
 * Description:
 */
public class SimpleTest {

    @Test
    public void testOne() {
        ServiceA serviceA = SimpleContainer.getInstance(ServiceA.class);
        serviceA.callB();
    }
}
