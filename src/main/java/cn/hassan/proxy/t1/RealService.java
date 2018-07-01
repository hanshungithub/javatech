package cn.hassan.proxy.t1;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/1 16:58
 * Description:
 */
public class RealService implements IService {
    @Override
    public void sayHello() {
        System.out.println("hello ...");
    }
}
