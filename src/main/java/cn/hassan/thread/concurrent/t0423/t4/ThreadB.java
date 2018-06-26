package cn.hassan.thread.concurrent.t0423.t4;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/24 8:22
 * Description:
 */
public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.awaitB();
	}
}
