package cn.hassan.thread.reentrantLock.t2;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/11 20:03
 * Description:
 */
public class TestMethod {
    public static void main(String[] args) {

        Thread thread = new Thread(FinalExample::writer);

        Thread thread1 = new Thread(FinalExample::reader);

        thread.start();
        thread1.start();
    }
}
