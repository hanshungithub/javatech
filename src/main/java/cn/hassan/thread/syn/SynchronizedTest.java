package cn.hassan.thread.syn;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/4 19:45
 * Description:
 *             1,普通同步方法，锁是当前实例对象
 *             2，静态同步方法，锁是当前类的class对象
 *             3，同步方法块，所示括号里面的对象
 */
public class SynchronizedTest {

    public synchronized void testOne() {
        System.out.println("testOne");
    }

    public synchronized static void testThree() {
        System.out.println("testThree");
    }

    public void testTwo() {
        synchronized (this){
            System.out.println("testTwo");
        }
    }
}
