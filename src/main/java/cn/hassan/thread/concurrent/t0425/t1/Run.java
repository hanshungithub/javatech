package cn.hassan.thread.concurrent.t0425.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/25 7:38
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		MyService service = new MyService();
		ThreadA threadA = new ThreadA(service);
		threadA.start();
		ThreadB threadB = new ThreadB(service);
		threadB.start();
	}
}
