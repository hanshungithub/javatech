package cn.hassan.thread.synchron.t1;


/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/5 7:29
 * Description: Junit单元测试不支持多线程
 */
public class SynchronizedTest2 {

	public static void main(String[] args) {
		/**
		 *  当一个线程执行同步方法时，其他线程不能访问任何同步方法
		 */
		SynchronizedDemo synDemo = new SynchronizedDemo();
		Thread thread3 = new Thread(() -> {
			synDemo.synMethod();
			synDemo.synMethod2();
		});
		Thread thread4 = new Thread(() -> {
			synDemo.synMethod2();
			synDemo.synMethod();
		});
		thread3.start();
		thread4.start();
	}
}
