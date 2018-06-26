package cn.hassan.thread.concurrent.t0416.t1;

public class TestMethod {
	public static void main(String[] args) {
		try {
			Mylist mylist = new Mylist();
			ThreadA threadA = new ThreadA(mylist);
			threadA.setName("A");
			threadA.start();
			Thread.sleep(50);
			ThreadB threadB = new ThreadB(mylist);
			threadB.setName("B");
			threadB.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
