package cn.hassan.thread.exeutor.executorservice;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;

/**
 * Created with idea
 * Author: hss
 * Date: 2018/6/27 10:03
 * Description:
 */
public class ExecutorTest {

	@Test
	public void testOne() {
		Executor executor = new SimpleExecutorService();
		executor.execute(() -> System.out.println("thread one"));
	}
}
