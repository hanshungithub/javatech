package cn.hassan.thread.concurrent.t0428.t1;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/28 7:33
 * Description:
 */
public class MyObject {
	private static MyObject object = new MyObject();

	private MyObject() {
	}

	public static MyObject getInstance() {
		return object;
	}
}
