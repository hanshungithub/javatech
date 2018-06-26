package cn.hassan.thread.concurrent.t0423.t4;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/24 8:23
 * Description:
 */
public class Run {
	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		ThreadA threadA = new ThreadA(service);
		threadA.setName("ThreadA");
		threadA.start();
		ThreadB threadB = new ThreadB(service);
		threadB.setName("ThreadB");
		threadB.start();
		Thread.sleep(3000);
		service.signalA();
	}
}
