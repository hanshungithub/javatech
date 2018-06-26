package cn.hassan.thread.concurrent.t0417.t2;

public class RunOne {
	public static ThreadLocal local = new ThreadLocal();

	public static void main(String[] args) {
		if (local.get() == null) {
			System.out.println("never set value");
			local.set("set value");
		}
		System.out.println(local.get());
		System.out.println(local.get());
	}
}
