package cn.hassan.thread.exeutor.executorservice;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/27 10:01
 * Description:
 */
public class SimpleExecutorService extends AbstractExecutorService {
	@Override
	public void shutdown() {

	}

	@Override
	public List<Runnable> shutdownNow() {
		return null;
	}

	@Override
	public boolean isShutdown() {
		return false;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}
}
