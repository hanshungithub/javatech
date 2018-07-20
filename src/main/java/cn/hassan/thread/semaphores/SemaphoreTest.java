package cn.hassan.thread.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with idea
 * Author: hss
 * Date: 7/20/2018 10:13 AM
 * Description:
 */
public class SemaphoreTest {
	private static final int THREAD_COUNT = 30;
	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
	private static Semaphore semaphore = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(() ->{
				try {
					semaphore.acquire();
					System.out.println("save data");
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
}
