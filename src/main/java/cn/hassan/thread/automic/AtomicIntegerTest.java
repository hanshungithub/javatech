package cn.hassan.thread.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/6/25 20:23
 * Description:
 */
public class AtomicIntegerTest {
    private static AtomicInteger counter = new AtomicInteger(0);
    static class Visitor extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for(int i = 0; i < num; i++) {
            threads[i] = new Visitor();
            threads[i].start();
        }
        for(int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.get());
    }
}
