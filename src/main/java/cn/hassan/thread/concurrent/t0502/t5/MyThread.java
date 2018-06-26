package cn.hassan.thread.concurrent.t0502.t5;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/4 8:24
 * Description:
 */
public class MyThread extends Thread {

    private CountDownLatch comingTag;//等待多有的运动员的到来
	private CountDownLatch waitTag;//等待裁判说开始
	private CountDownLatch waitRunTag;//等待起跑
	private CountDownLatch beginTag;//起跑
	private CountDownLatch endTag;//所有运动员到达终点

	public MyThread(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag, CountDownLatch beginTag, CountDownLatch endTag) {
		this.comingTag = comingTag;
		this.waitTag = waitTag;
		this.waitRunTag = waitRunTag;
		this.beginTag = beginTag;
		this.endTag = endTag;
	}

	@Override
	public void run() {
		try {
			System.out.println("运动员使用不同的交通工具达到起跑点，正向这头来");
			Thread.sleep((int) (Math.random() * 10000));
			System.out.println(Thread.currentThread().getName() + "到达起跑点了");
			comingTag.countDown();
			System.out.println("裁判员说开始");
			waitTag.countDown();
			System.out.println("各就各位，准备开始");
			Thread.sleep((long) (Math.random()*10000));
			waitRunTag.countDown();
			beginTag.countDown();
			System.out.println(Thread.currentThread().getName() + "所有运动员起跑，并且赛跑过程不确定");
			endTag.countDown();
			System.out.println(Thread.currentThread().getName() + "所有运动员到达终点");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
