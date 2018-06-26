package cn.hassan.thread.concurrent.t0502.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/2 8:29
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA threadA = new ThreadA(service);
		threadA.setName("ThreadA");

		ThreadB threadB = new ThreadB(service);
		threadB.setName("ThreadB");

		threadA.start();
		threadB.start();
	}
}
