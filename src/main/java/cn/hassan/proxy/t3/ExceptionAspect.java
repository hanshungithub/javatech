package cn.hassan.proxy.t3;

import cn.hassan.annotation.t2.ServiceB;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 19:17
 * Description:
 */
@Aspect(ServiceB.class)
public class ExceptionAspect {

    public static void exception(Object object,Method method, Object[] args, Throwable e) {
        System.err.println("exception when calling: "+ method.getName() + "," + Arrays.toString(args));
    }
}
