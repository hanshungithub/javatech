package cn.hassan.thread.concurrent.t0502.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/2 8:28
 * Description:
 */
public class ThreadA extends Thread {

	private Service service;

	public ThreadA(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
