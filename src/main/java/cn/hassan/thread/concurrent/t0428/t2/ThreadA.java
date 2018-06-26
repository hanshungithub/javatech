package cn.hassan.thread.concurrent.t0428.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/28 7:40
 * Description:
 */
public class ThreadA extends Thread {
	@Override
	public void run() {
		System.out.println(MyObject.getInstance().hashCode());
	}
}
