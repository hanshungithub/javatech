package cn.hassan.proxy.t2;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 18:55
 * Description:
 */
public class ProxyContainer {

    public static <T> T getInstance(Class<RealService> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new SimpleInterceptoe());
        return (T)enhancer.create();
    }
}
