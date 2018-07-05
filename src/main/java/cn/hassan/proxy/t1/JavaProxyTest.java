package cn.hassan.proxy.t1;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 17:03
 * Description:
 */
public class JavaProxyTest {

    /**
     * JDK动态代理 定义的本身与被代理的对象没有关系，与InvocationHandler的具体实现没有关系，而主要与接口数组有关
     * 给定接口数据，他动态创建每个接口的具体实现，实现就转给InvocationHandler，与被代理的对象关系以及对它的调用
     * 有invocationHandler实现
     */
    @Test
    public void testOne() {
        RealService service = new RealService();
        SimpleInvocationHandler handler = new SimpleInvocationHandler(service);
        IService proxyInstance = (IService)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        proxyInstance.sayHello();
    }
}
