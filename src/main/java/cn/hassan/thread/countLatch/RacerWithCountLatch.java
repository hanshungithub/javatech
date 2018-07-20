package cn.hassan.thread.countLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/27 21:05
 * Description: 倒计时为0的时候开始执行
 */
public class RacerWithCountLatch {

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(1);
        Thread[] racers = new Thread[num];
        for(int i = 0; i < num; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }
        Thread.sleep(1000);
        System.out.println("线程开始运行了！");
        latch.countDown();
    }

	static class Racer extends Thread{
		CountDownLatch countDownLatch;

		Racer(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			try {
				this.countDownLatch.await();
				System.out.println(getName() + " start run " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
