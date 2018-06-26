package cn.hassan.thread.concurrent.t0417.t1;

public class ThreadProducer extends Thread {

	private Producer producer;

	public ThreadProducer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		super.run();
		producer.setValue();
	}
}
