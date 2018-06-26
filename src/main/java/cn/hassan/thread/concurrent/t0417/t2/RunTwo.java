package cn.hassan.thread.concurrent.t0417.t2;

public class RunTwo {
	public static void main(String[] args) {
		try {
			ThreadA threadA = new ThreadA();
			ThreadB threadB = new ThreadB();
			threadA.start();
			threadB.start();
			for (int i = 0; i < 100; i++) {
				Tools.local.set("Main ---> " + (i + 1));
				System.out.println("Main get value = " + Tools.local.get());
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
