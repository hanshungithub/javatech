package cn.hassan.thread.concurrent.t0427.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/27 7:52
 * Description:
 */
public class ThreadB extends Thread {

	private Service service;

	public ThreadB(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.read();
	}
}
