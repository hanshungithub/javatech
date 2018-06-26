package cn.hassan.thread.concurrent.t0428.t2;

/**
 * Created with IntelliJ IDEA.
 * User: hss
 * Date: 2018/4/28 7:38
 * Description:
 */
public class MyObject {

	private static MyObject object;

	private MyObject() {
	}

	public static MyObject getInstance() {
		if (object == null) {
			return new MyObject();
		}
		return object;
	}
}
