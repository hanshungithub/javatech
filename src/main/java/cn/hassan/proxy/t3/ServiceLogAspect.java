package cn.hassan.proxy.t3;

import cn.hassan.annotation.t2.ServiceA;
import cn.hassan.annotation.t2.ServiceB;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 19:15
 * Description:
 */
@Aspect({ServiceA.class, ServiceB.class})
public class ServiceLogAspect {

    public static void before(Object object, Method method, Object[] args) {
        System.out.println("entering " + method.getDeclaringClass().getSimpleName() + "::" + method.getName()+ ", args: " + Arrays.toString(args));
    }

    public static void after(Object object, Method method, Object[] args,Object result) {
        System.out.println("leaving " + method.getDeclaringClass().getSimpleName() + "::" + method.getName()+ ", result: " + result);
    }
}
