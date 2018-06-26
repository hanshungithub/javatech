package cn.hassan.thread.concurrent.t0417.t1;

public class Consumer {
	private String lock;

	public Consumer(String lock) {
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					lock.wait();
				}
				System.out.println("get value ---> " + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
