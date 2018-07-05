package cn.hassan.thread.synchron.t1;


/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/5 7:29
 * Description: Junit单元测试不支持多线程
 */
public class SynchronizedTest1 {

	public static void main(String[] args) {

		/**
		 *  当一个线程进入同步方法时，其他线程可以正常访问其他非同步方法
		 */
		SynchronizedDemo synDemo = new SynchronizedDemo();
		//调用普通方法
		Thread thread1 = new Thread(synDemo::method);
		//调用同步方法
		Thread thread2 = new Thread(synDemo::synMethod);
		thread1.start();
		thread2.start();
	}
}
