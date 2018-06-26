package cn.hassan.thread.concurrent.t0519.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/19 10:10
 * Description:
 */
public class Run {
	public static void main(String[] args) {
/*		MyServiceOne serviceOne = new MyServiceOne();

		Thread threadOne = new ThreadA(serviceOne);
		Thread threadTwo = new ThreadB(serviceOne);

		threadOne.start();
		threadTwo.start();*/

		MyHello hello = new MyHello();
		hello.say();
	}
}
