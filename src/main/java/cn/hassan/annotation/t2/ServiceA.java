package cn.hassan.annotation.t2;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 14:49
 * Description:
 */
public class ServiceA {

    @SimpleInject
    ServiceB serviceB;

    public void callB() {
        serviceB.action();
    }
}
