package cn.hassan.thread.exchanges;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with idea
 * Author: hss
 * Date: 7/20/2018 10:44 AM
 * Description:
 */
public class ExchangerTest {
	private static final Exchanger<String> exg = new Exchanger<>();
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(() -> {
			try {
			String A = "stream A";
			exg.exchange(A);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		threadPool.execute(() -> {
			try {
				String B = "stream B";
				String A = exg.exchange(B);
				System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
