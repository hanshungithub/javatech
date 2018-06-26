package cn.hassan.thread.concurrent.t0417.t1;

public class TestMethod {
	public static void main(String[] args) {
		String str = "";
		Producer producer = new Producer(str);
		Consumer consumer = new Consumer(str);

		ThreadProducer producer1 = new ThreadProducer(producer);
		ThreadConsumer consumer1 = new ThreadConsumer(consumer);
		producer1.start();
		consumer1.start();
	}
}
