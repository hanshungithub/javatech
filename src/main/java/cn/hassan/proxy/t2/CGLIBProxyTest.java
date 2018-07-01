package cn.hassan.proxy.t2;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 18:50
 * Description:
 */
public class CGLIBProxyTest {

    /**
     * cglib的代理是通过继承来实现的，它也动态的创建了一个类，这个类的父类是被代理的类，代理类重写了父类的public和
     * 非final方法，改为调用callback中的方法
     */
    @Test
    public void testOne() {
        RealService instance = (RealService)ProxyContainer.getInstance(RealService.class);
        instance.sayHello();
    }
}
