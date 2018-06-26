package cn.hassan.thread.concurrent.t0423.t3;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/24 7:30
 * Description:
 */
public class Run {
	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		ThreadA threadA = new ThreadA(service);
		threadA.start();
		Thread.sleep(3000);
		service.signal();
	}
}
