package cn.hassan.thread.concurrent.t0502.t3;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/3 7:44
 * Description:
 */
public class MyThread extends Thread {

	private ListPool listPool;

	public MyThread(ListPool listPool) {
		this.listPool = listPool;
	}

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String str = listPool.get();
			System.out.println(Thread.currentThread().getName() + "acquire value" + str);
			listPool.set(str);
		}
	}
}
