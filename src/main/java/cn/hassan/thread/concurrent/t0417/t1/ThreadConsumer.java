package cn.hassan.thread.concurrent.t0417.t1;

public class ThreadConsumer extends Thread {
	private Consumer consumer;

	public ThreadConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public void run() {
		super.run();
		consumer.getValue();
	}
}
