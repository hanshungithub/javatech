package cn.hassan.proxy.t2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 18:38
 * Description:
 */
public class SimpleInterceptoe implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("entering --->" + method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("leaving ---> " + method.getName());
        return o1;
    }
}
