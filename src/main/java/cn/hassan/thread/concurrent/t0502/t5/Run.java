package cn.hassan.thread.concurrent.t0502.t5;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/7 7:40
 * Description:
 */
public class Run {
	public static void main(String[] args) {
		try {
			CountDownLatch comingTag = new CountDownLatch(10);
			CountDownLatch waitTag = new CountDownLatch(10);
			CountDownLatch waitRunTag = new CountDownLatch(10);
			CountDownLatch beginTag = new CountDownLatch(10);
			CountDownLatch endTag = new CountDownLatch(10);

			MyThread[] thread = new MyThread[10];
			for (int i = 0; i < 10; i++) {
				thread[i] = new MyThread(comingTag, waitTag, waitRunTag, beginTag, endTag);
				thread[i].start();
			}
			System.out.println("裁判等待所有的运动员的到来");
			comingTag.await();
			System.out.println("裁判开到所有的运动员到来了，巡视5秒");
			Thread.sleep(5000);
			waitTag.await();
			System.out.println("各就各位");
			waitRunTag.await();
			Thread.sleep(2000);
			System.out.println("发铃声响起");
			beginTag.await();
			endTag.await();
			System.out.println("所有运动员到达终点，统计比赛名次");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
