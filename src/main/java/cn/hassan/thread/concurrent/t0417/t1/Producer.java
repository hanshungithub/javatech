package cn.hassan.thread.concurrent.t0417.t1;

public class Producer {
	private String lock;

	public Producer(String lock) {
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("set value ---> " + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
