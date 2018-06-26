package cn.hassan.thread.concurrent.t0515.t1;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/15 17:17
 * Description:
 */
public class Run2 {
	public static void main(String[] args) throws Exception {

		MyCallBack back = new MyCallBack(25);

		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
		Future<String> submit = executor.submit(back);
		System.out.println(submit.get());

		executor.submit(() -> {

		});
	}
}
