package cn.hassan.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/27 21:15
 * Description:
 */
public class CyclicBarrierTest {

    static class Tourist extends Thread{
        CyclicBarrier cyclicBarrier;

        public Tourist(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("到达集A合点之前！");
                Thread.sleep((long) (Math.random() * 1000));
                cyclicBarrier.await();
                System.out.println(getName() + "arrived A" + System.currentTimeMillis());
                System.out.println("到达集B合点之前！");
                Thread.sleep((long) (Math.random() * 1000));
                cyclicBarrier.await();
                System.out.println(getName() + "arrived B" + System.currentTimeMillis());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int num = 3;
        Tourist[] tourist = new Tourist[3];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num, () -> System.out.println("all arrived " + System.currentTimeMillis() + " executed by " + Thread.currentThread().getName()));

        for (int i = 0; i < 3; i++) {
            tourist[i] = new Tourist(cyclicBarrier);
            tourist[i].start();
        }
    }
}
