package cn.hassan.thread.concurrent.t0423.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/23 7:25
 * Description:
 */
public class Run {
	public static ThreadLocalExt ext = new ThreadLocalExt();
	public static void main(String[] args) {
		if (ext.get() == null) {
			System.out.println("never set value");
			ext.set("my value");
		}
		System.out.println(ext.get());
		System.out.println(ext.get());
	}
}
