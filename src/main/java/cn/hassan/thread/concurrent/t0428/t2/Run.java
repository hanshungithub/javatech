package cn.hassan.thread.concurrent.t0428.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/28 7:40
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		ThreadA thread1 = new ThreadA();
		ThreadA thread2 = new ThreadA();
		ThreadA thread3 = new ThreadA();
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
