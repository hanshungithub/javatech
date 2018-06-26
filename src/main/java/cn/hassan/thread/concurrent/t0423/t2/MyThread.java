package cn.hassan.thread.concurrent.t0423.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/23 7:51
 * Description:
 */
public class MyThread extends Thread {

	private MyService service;

	public MyThread(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}
