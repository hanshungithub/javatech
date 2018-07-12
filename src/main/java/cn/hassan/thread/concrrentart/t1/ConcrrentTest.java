package cn.hassan.thread.concrrentart.t1;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/7/10 7:43
 * Description:
 */
public class ConcrrentTest {

	private static final long count = 100001;

	public static void main(String[] args) {

	}

	public static void concurrent() {
		long start = System.currentTimeMillis();
		Thread thread = new Thread(() -> {
			int a = 0;
			for (long i = 0; i < count; i++) {
				a += 5;
			}
		});
	}
}
