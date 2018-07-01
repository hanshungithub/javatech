package cn.hassan.proxy.t1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 17:00
 * Description:
 */
public class SimpleInvocationHandler implements InvocationHandler {

    private Object realObj;

    public SimpleInvocationHandler(Object realObj) {
        this.realObj = realObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method entering ---> " + method.getName());
        Object invoke = method.invoke(realObj, args);
        System.out.println("method leaving ---> " + method.getName());
        return invoke;
    }
}
