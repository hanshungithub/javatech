package cn.hassan.thread.concurrent.t0511.t1;

import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/5/11 8:20
 * Description:
 */
public class MyThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("The Thread Is From ThreadFacytory" + Math.random());
		return thread;
	}
}
