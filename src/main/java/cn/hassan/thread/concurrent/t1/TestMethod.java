package cn.hassan.thread.concurrent.t1;

import org.junit.Test;

public class TestMethod {

	@Test
	public void test01() {
		ThreadTwo threadTwo = new ThreadTwo();

		Thread a = new Thread(threadTwo, "A");
		Thread b = new Thread(threadTwo, "B");
		Thread c = new Thread(threadTwo, "C");
		Thread d = new Thread(threadTwo, "D");
		Thread e = new Thread(threadTwo, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}

	@Test
	public void testTwo() {
		Alogin alogin = new Alogin();
		alogin.start();
		Blogin blogin = new Blogin();
		blogin.start();
	}
}
