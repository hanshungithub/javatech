package cn.hassan.thread.concurrent.t1;

public class TestMethod {
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
	public void testTwo() {
		Alogin alogin = new Alogin();
		alogin.start();
		Blogin blogin = new Blogin();
		blogin.start();
	}
}
