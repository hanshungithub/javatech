package cn.hassan.thread.voliatle.t1;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/11 17:22
 * Description:
 */
public class TestMethod {

    public static void main(String[] args) throws Exception{

        VolatileFeaturesExample example = new VolatileFeaturesExample();

        Thread thread = new Thread(() -> example.set(2L));

        Thread thread1 = new Thread(example::getAndIncrement);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(example.get());
    }
}
