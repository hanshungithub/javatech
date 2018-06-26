package cn.hassan.thread.concurrent.t0423.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/23 8:17
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		MyService service = new MyService();
		MyThread thread = new MyThread(service);
		MyThread thread1 = new MyThread(service);
		MyThread thread2 = new MyThread(service);
		MyThread thread3 = new MyThread(service);
		MyThread thread4 = new MyThread(service);
		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
