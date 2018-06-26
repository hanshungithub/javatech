package cn.hassan.thread.concurrent.t0502.t4;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/4 7:43
 * Description:
 */
public class Run {
	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
		MyThread[] threads = new MyThread[10];

		for (int i = 0; i < 10; i++) {
			threads[i] = new MyThread(service);
			threads[i].setName("Thread --- " + (i + 1));
			threads[i].start();
		}

		Thread.sleep(2000);
		service.downMehtod();
	}
}
