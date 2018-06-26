package cn.hassan.thread.concurrent.t0425.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/25 7:37
 * Description:
 */
public class ThreadB extends Thread {
	private MyService service;

	public ThreadB(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			service.get();
		}
	}
}
