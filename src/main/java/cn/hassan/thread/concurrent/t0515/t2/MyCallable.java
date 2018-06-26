package cn.hassan.thread.concurrent.t0515.t2;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/16 7:33
 * Description:
 */
public class MyCallable implements Callable<String> {

	private String username;
	private long sleepValue;

	public MyCallable(String username, long sleepValue) {
		this.username = username;
		this.sleepValue = sleepValue;
	}

	@Override
	public String call() throws Exception {
		System.out.println("username ---> " + username);
		Thread.sleep(sleepValue);
		return "return ---> " + username;
	}
}
