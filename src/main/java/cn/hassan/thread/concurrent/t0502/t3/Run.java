package cn.hassan.thread.concurrent.t0502.t3;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/3 7:48
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		ListPool pool = new ListPool();
		MyThread[] threads = new MyThread[12];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MyThread(pool);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
