package cn.hassan.thread.concurrent.t0502.t4;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/4 7:41
 * Description:
 */
public class MyThread extends Thread {

	private MyService service;

	public MyThread(MyService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
