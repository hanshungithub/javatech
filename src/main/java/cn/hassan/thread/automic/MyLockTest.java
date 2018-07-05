package cn.hassan.thread.automic;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/5 22:39
 * Description:
 */
public class MyLockTest {
    public static void main(String[] args) {
        final MyLock lock = new MyLock();

        Thread thread = new Thread(lock::lock);
        thread.start();
    }
}
